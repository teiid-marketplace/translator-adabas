/*
 * JBoss, Home of Professional Open Source.
 * See the COPYRIGHT.txt file distributed with this work for information
 * regarding copyright ownership.  Some portions may be licensed
 * to Red Hat, Inc. under one or more contributor license agreements.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301 USA.
 */

package org.teiid.translator.adabas;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.teiid.language.Function;
import org.teiid.translator.SourceSystemFunctions;
import org.teiid.translator.Translator;
import org.teiid.translator.TranslatorException;
import org.teiid.translator.TypeFacility;
import org.teiid.translator.jdbc.ConvertModifier;
import org.teiid.translator.jdbc.FunctionModifier;
import org.teiid.translator.jdbc.JDBCExecutionFactory;

@Translator(name="adabas", description="Adabas Translator")
public class AdabasExecutionFactory extends JDBCExecutionFactory {

    private static final String ADABAS = "adabas"; //$NON-NLS-1$
	
    @Override
    public void start() throws TranslatorException {
        super.start();
        AdabasConvertModifier convertModifier = new AdabasConvertModifier();
        convertModifier.addTypeMapping("integer", FunctionModifier.INTEGER); //$NON-NLS-1$
        convertModifier.addTypeMapping("long", FunctionModifier.LONG); //$NON-NLS-1$
        convertModifier.addTypeMapping("bigint", FunctionModifier.LONG); //$NON-NLS-1$
        convertModifier.addTypeMapping("smallint", FunctionModifier.SHORT); //$NON-NLS-1$
        convertModifier.addTypeMapping("tinyint", FunctionModifier.BYTE); //$NON-NLS-1$
        convertModifier.addTypeMapping("date", FunctionModifier.DATE); //$NON-NLS-1$
        convertModifier.addTypeMapping("timestamp", FunctionModifier.TIMESTAMP); //$NON-NLS-1$
        convertModifier.addTypeMapping("time", FunctionModifier.TIME); //$NON-NLS-1$
        convertModifier.addTypeMapping("double", FunctionModifier.DOUBLE); //$NON-NLS-1$
        convertModifier.addTypeMapping("float", FunctionModifier.FLOAT); //$NON-NLS-1$
        convertModifier.addTypeMapping("decimal", FunctionModifier.BIGDECIMAL); //$NON-NLS-1$
        convertModifier.addTypeMapping("varchar", FunctionModifier.STRING); //$NON-NLS-1$
        convertModifier.addTypeMapping("char(1)", FunctionModifier.CHAR); //$NON-NLS-1$
        
        convertModifier.addConvert(FunctionModifier.BYTE, FunctionModifier.STRING, new CastModifier("char(3)"));  //$NON-NLS-1$
        convertModifier.addConvert(FunctionModifier.SHORT, FunctionModifier.STRING, new CastModifier("char(3)"));  //$NON-NLS-1$
        convertModifier.addConvert(FunctionModifier.INTEGER, FunctionModifier.STRING, new CastModifier("char(15)"));  //$NON-NLS-1$
        convertModifier.addConvert(FunctionModifier.LONG, FunctionModifier.STRING, new CastModifier("char(15)"));  //$NON-NLS-1$
        convertModifier.addConvert(FunctionModifier.DOUBLE, FunctionModifier.STRING, new CastModifier("char(30)"));  //$NON-NLS-1$
        convertModifier.addConvert(FunctionModifier.FLOAT, FunctionModifier.STRING, new CastModifier("char(30)"));  //$NON-NLS-1$
        convertModifier.addConvert(FunctionModifier.BIGINTEGER, FunctionModifier.STRING, new CastModifier("char(50)"));  //$NON-NLS-1$
        convertModifier.addConvert(FunctionModifier.BIGDECIMAL, FunctionModifier.STRING, new CastModifier("char(50)"));  //$NON-NLS-1$

        registerFunctionModifier(SourceSystemFunctions.CONVERT, convertModifier);
        
        addPushDownFunction(ADABAS, "connxcdd", TypeFacility.RUNTIME_NAMES.STRING); //$NON-NLS-1$
        addPushDownFunction(ADABAS, "XPUSERNAME", TypeFacility.RUNTIME_NAMES.STRING); //$NON-NLS-1$
        addPushDownFunction(ADABAS, "NTUSERNAME", TypeFacility.RUNTIME_NAMES.STRING); //$NON-NLS-1$
        addPushDownFunction(ADABAS, "EXTRACT", TypeFacility.RUNTIME_NAMES.INTEGER, TypeFacility.RUNTIME_NAMES.TIMESTAMP); //$NON-NLS-1$
        addPushDownFunction(ADABAS, "BIT_LENGTH", TypeFacility.RUNTIME_NAMES.INTEGER, TypeFacility.RUNTIME_NAMES.STRING); //$NON-NLS-1$
        addPushDownFunction(ADABAS, "CHAR_LENGTH", TypeFacility.RUNTIME_NAMES.INTEGER, TypeFacility.RUNTIME_NAMES.STRING); //$NON-NLS-1$
        addPushDownFunction(ADABAS, "HEX", TypeFacility.RUNTIME_NAMES.STRING, TypeFacility.RUNTIME_NAMES.INTEGER); //$NON-NLS-1$
        addPushDownFunction(ADABAS, "OCTET_LENGTH", TypeFacility.RUNTIME_NAMES.INTEGER, TypeFacility.RUNTIME_NAMES.STRING); //$NON-NLS-1$
        addPushDownFunction(ADABAS, "POSITION", TypeFacility.RUNTIME_NAMES.INTEGER, TypeFacility.RUNTIME_NAMES.STRING); //$NON-NLS-1$
        addPushDownFunction(ADABAS, "SOUNDEX", TypeFacility.RUNTIME_NAMES.INTEGER, TypeFacility.RUNTIME_NAMES.STRING); //$NON-NLS-1$
        addPushDownFunction(ADABAS, "SOUNDEX", TypeFacility.RUNTIME_NAMES.STRING, TypeFacility.RUNTIME_NAMES.INTEGER); //$NON-NLS-1$
        // extract needs little work
        //addPushDownFunction(ADABAS, "EXTRACT", TypeFacility.RUNTIME_NAMES.STRING, TypeFacility.RUNTIME_NAMES.INTEGER); //$NON-NLS-1$
        addPushDownFunction(ADABAS, "DIFFERENCE", TypeFacility.RUNTIME_NAMES.INTEGER, TypeFacility.RUNTIME_NAMES.STRING, TypeFacility.RUNTIME_NAMES.STRING); //$NON-NLS-1$
    }

    public static class AdabasConvertModifier extends ConvertModifier {
        @Override
        public List<?> translate(Function function) {
            List values = super.translate(function);
            function.setName("convert"); //$NON-NLS-1$
            return values;
        }        
    }
    
    public static class CastModifier extends FunctionModifier {
        private String target;
        public CastModifier(String target) {
            this.target = target;
        }
        @Override
        public List<?> translate(Function function) {
            return Arrays.asList("convert(", function.getParameters().get(0), ", "+this.target+")");    //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        }
    }    

    @Override
    public boolean supportsDependentJoins() {
        return true;
    }
        
    @Override
    public boolean supportsRowLimit() {
        return true;
    }
    
    @Override
    public boolean supportsRowOffset() {
        return true;
    }
    
    @Override
    public boolean supportsSubqueryInOn() {
        return true;
    }

    @Override
    public boolean supportsInlineViews() {
        return true;
    } 
    
    @Override
    public List<String> getSupportedFunctions() {
        List<String> supportedFunctions = new ArrayList<String>();
        supportedFunctions.addAll(super.getSupportedFunctions());

        //String functions
        supportedFunctions.add(SourceSystemFunctions.ASCII); 
        supportedFunctions.add(SourceSystemFunctions.CHAR); // chr alias
        supportedFunctions.add(SourceSystemFunctions.CONCAT);
        supportedFunctions.add(SourceSystemFunctions.LCASE);
        supportedFunctions.add(SourceSystemFunctions.LEFT);
        supportedFunctions.add(SourceSystemFunctions.LENGTH);
        supportedFunctions.add(SourceSystemFunctions.LOCATE);
        supportedFunctions.add(SourceSystemFunctions.LTRIM);
        supportedFunctions.add(SourceSystemFunctions.REPEAT);
        supportedFunctions.add(SourceSystemFunctions.REPLACE);
        supportedFunctions.add(SourceSystemFunctions.RIGHT);
        supportedFunctions.add(SourceSystemFunctions.RTRIM);
        supportedFunctions.add(SourceSystemFunctions.SUBSTRING);
        supportedFunctions.add(SourceSystemFunctions.UCASE);
        supportedFunctions.add(SourceSystemFunctions.CONVERT);
        
        // date functions
        supportedFunctions.add(SourceSystemFunctions.CURDATE);
        supportedFunctions.add(SourceSystemFunctions.CURTIME);
        supportedFunctions.add(SourceSystemFunctions.DAYNAME);
        supportedFunctions.add(SourceSystemFunctions.DAYOFMONTH);
        supportedFunctions.add(SourceSystemFunctions.DAYOFWEEK);
        supportedFunctions.add(SourceSystemFunctions.DAYOFYEAR);
        supportedFunctions.add(SourceSystemFunctions.HOUR);
        supportedFunctions.add(SourceSystemFunctions.MINUTE);
        supportedFunctions.add(SourceSystemFunctions.MONTH);
        supportedFunctions.add(SourceSystemFunctions.MONTHNAME);
        supportedFunctions.add(SourceSystemFunctions.NOW);
        supportedFunctions.add(SourceSystemFunctions.QUARTER);
        supportedFunctions.add(SourceSystemFunctions.SECOND);
        supportedFunctions.add(SourceSystemFunctions.TIMESTAMPADD);
        supportedFunctions.add(SourceSystemFunctions.TIMESTAMPDIFF);
        
        // Numeric Functions
        supportedFunctions.add(SourceSystemFunctions.ABS); 
        supportedFunctions.add(SourceSystemFunctions.ACOS); 
        supportedFunctions.add(SourceSystemFunctions.ASIN); 
        supportedFunctions.add(SourceSystemFunctions.ATAN);
        supportedFunctions.add(SourceSystemFunctions.ATAN2);    
        supportedFunctions.add(SourceSystemFunctions.CEILING);
        supportedFunctions.add(SourceSystemFunctions.COS);
        supportedFunctions.add(SourceSystemFunctions.COT);
        supportedFunctions.add(SourceSystemFunctions.DEGREES);
        supportedFunctions.add(SourceSystemFunctions.EXP);
        supportedFunctions.add(SourceSystemFunctions.FLOOR);
        supportedFunctions.add(SourceSystemFunctions.LOG);
        supportedFunctions.add(SourceSystemFunctions.LOG10);
        supportedFunctions.add(SourceSystemFunctions.MOD);
        supportedFunctions.add(SourceSystemFunctions.PI);
        supportedFunctions.add(SourceSystemFunctions.POWER);
        supportedFunctions.add(SourceSystemFunctions.RADIANS);
        supportedFunctions.add(SourceSystemFunctions.RAND);
        supportedFunctions.add(SourceSystemFunctions.ROUND);
        supportedFunctions.add(SourceSystemFunctions.SIGN);
        supportedFunctions.add(SourceSystemFunctions.SQRT);
        supportedFunctions.add(SourceSystemFunctions.TAN);
        supportedFunctions.add(SourceSystemFunctions.TRUNCATE);
        
        supportedFunctions.add(SourceSystemFunctions.IFNULL);
        supportedFunctions.add(SourceSystemFunctions.NULLIF);
        supportedFunctions.add(SourceSystemFunctions.COALESCE);
        
        return supportedFunctions;
    }

    /*
    * Since CONNX does not support some methods of JDBC API, we need to wrap the
    * object to provide some alternatives so the query can run without problems.
    *
    * The problem is on get methods that takes a Calendar and all set methods.
    * They all throws exceptions saying that the method is not supported.
    *
    * Note that these wrappers only solves the get methods.
    */

    @Override
    public Object retrieveValue(ResultSet results, int columnIndex, Class<?> expectedType) throws SQLException {
        return super.retrieveValue(new ConnxResultSetWrapper(results), columnIndex, expectedType);
    }

    @Override
    public Object retrieveValue(CallableStatement results, int parameterIndex, Class<?> expectedType) throws SQLException {
        return super.retrieveValue(new ConnxCallableStatementWrapper(results), parameterIndex, expectedType);
    }
}
