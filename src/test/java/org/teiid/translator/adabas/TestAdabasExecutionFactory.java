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

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;
import org.teiid.language.Expression;
import org.teiid.language.Function;
import org.teiid.language.LanguageFactory;
import org.teiid.translator.TypeFacility;
import org.teiid.translator.jdbc.SQLConversionVisitor;

@SuppressWarnings("nls")
public class TestAdabasExecutionFactory {
    
    private static final LanguageFactory LANG_FACTORY = new LanguageFactory();
    private static AdabasExecutionFactory TRANSLATOR = new AdabasExecutionFactory(); 
    
    @BeforeClass
    public static void oneTimeSetup() throws Exception {
        TRANSLATOR.start();
    }
    
    public String helpGetString(Expression expr) throws Exception {
        AdabasExecutionFactory trans = new AdabasExecutionFactory();
        trans.start();
        
        SQLConversionVisitor sqlVisitor = TRANSLATOR.getSQLConversionVisitor(); 
        sqlVisitor.append(expr);  
        
        return sqlVisitor.toString();        
    }

    public void helpTest(Expression srcExpression, String tgtType, String expectedExpression) throws Exception {
        Function func = LANG_FACTORY.createFunction("convert",  
            Arrays.asList( 
                srcExpression,
                LANG_FACTORY.createLiteral(tgtType, String.class)),
            TypeFacility.getDataTypeClass(tgtType));
        
        assertEquals("Error converting from " + srcExpression.getType() + " to " + tgtType, 
            expectedExpression, helpGetString(func)); 
    }

    @Test
    public void testIntToChar() throws Exception {
        helpTest(LANG_FACTORY.createLiteral(5123, Integer.class), "string", "convert(5123, char(15))"); 
    }    

}
