package org.teiid.translator.adabas;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Map;

public class ConnxResultSetWrapper implements ResultSet {

  private final ResultSet realResultSet;

  public ConnxResultSetWrapper(ResultSet realResultSet) {
    this.realResultSet = realResultSet;
  }

  // CONNX does not support this method
  public Date getDate(int columnIndex, Calendar cal) throws SQLException {
    return realResultSet.getDate(columnIndex);
  }

  // CONNX does not support this method
  public Date getDate(String columnLabel, Calendar cal) throws SQLException {
    return realResultSet.getDate(columnLabel);
  }

  // CONNX does not support this method
  public Time getTime(int columnIndex, Calendar cal) throws SQLException {
    return realResultSet.getTime(columnIndex);
  }

  // CONNX does not support this method
  public Time getTime(String columnLabel, Calendar cal) throws SQLException {
    return realResultSet.getTime(columnLabel);
  }

  // CONNX does not support this method
  public Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException {
    return realResultSet.getTimestamp(columnIndex);
  }

  // CONNX does not support this method
  public Timestamp getTimestamp(String columnLabel, Calendar cal) throws SQLException {
    return realResultSet.getTimestamp(columnLabel);
  }

  public boolean next() throws SQLException {
    return realResultSet.next();
  }

  public void close() throws SQLException {
    realResultSet.close();
  }

  public boolean wasNull() throws SQLException {
    return realResultSet.wasNull();
  }

  public String getString(int columnIndex) throws SQLException {
    return realResultSet.getString(columnIndex);
  }

  public boolean getBoolean(int columnIndex) throws SQLException {
    return realResultSet.getBoolean(columnIndex);
  }

  public byte getByte(int columnIndex) throws SQLException {
    return realResultSet.getByte(columnIndex);
  }

  public short getShort(int columnIndex) throws SQLException {
    return realResultSet.getShort(columnIndex);
  }

  public int getInt(int columnIndex) throws SQLException {
    return realResultSet.getInt(columnIndex);
  }

  public long getLong(int columnIndex) throws SQLException {
    return realResultSet.getLong(columnIndex);
  }

  public float getFloat(int columnIndex) throws SQLException {
    return realResultSet.getFloat(columnIndex);
  }

  public double getDouble(int columnIndex) throws SQLException {
    return realResultSet.getDouble(columnIndex);
  }

  public BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
    return realResultSet.getBigDecimal(columnIndex, scale);
  }

  public byte[] getBytes(int columnIndex) throws SQLException {
    return realResultSet.getBytes(columnIndex);
  }

  public Date getDate(int columnIndex) throws SQLException {
    return realResultSet.getDate(columnIndex);
  }

  public Time getTime(int columnIndex) throws SQLException {
    return realResultSet.getTime(columnIndex);
  }

  public Timestamp getTimestamp(int columnIndex) throws SQLException {
    return realResultSet.getTimestamp(columnIndex);
  }

  public InputStream getAsciiStream(int columnIndex) throws SQLException {
    return realResultSet.getAsciiStream(columnIndex);
  }

  public InputStream getUnicodeStream(int columnIndex) throws SQLException {
    return realResultSet.getUnicodeStream(columnIndex);
  }

  public InputStream getBinaryStream(int columnIndex) throws SQLException {
    return realResultSet.getBinaryStream(columnIndex);
  }

  public String getString(String columnLabel) throws SQLException {
    return realResultSet.getString(columnLabel);
  }

  public boolean getBoolean(String columnLabel) throws SQLException {
    return realResultSet.getBoolean(columnLabel);
  }

  public byte getByte(String columnLabel) throws SQLException {
    return realResultSet.getByte(columnLabel);
  }

  public short getShort(String columnLabel) throws SQLException {
    return realResultSet.getShort(columnLabel);
  }

  public int getInt(String columnLabel) throws SQLException {
    return realResultSet.getInt(columnLabel);
  }

  public long getLong(String columnLabel) throws SQLException {
    return realResultSet.getLong(columnLabel);
  }

  public float getFloat(String columnLabel) throws SQLException {
    return realResultSet.getFloat(columnLabel);
  }

  public double getDouble(String columnLabel) throws SQLException {
    return realResultSet.getDouble(columnLabel);
  }

  public BigDecimal getBigDecimal(String columnLabel, int scale) throws SQLException {
    return realResultSet.getBigDecimal(columnLabel, scale);
  }

  public byte[] getBytes(String columnLabel) throws SQLException {
    return realResultSet.getBytes(columnLabel);
  }

  public Date getDate(String columnLabel) throws SQLException {
    return realResultSet.getDate(columnLabel);
  }

  public Time getTime(String columnLabel) throws SQLException {
    return realResultSet.getTime(columnLabel);
  }

  public Timestamp getTimestamp(String columnLabel) throws SQLException {
    return realResultSet.getTimestamp(columnLabel);
  }

  public InputStream getAsciiStream(String columnLabel) throws SQLException {
    return realResultSet.getAsciiStream(columnLabel);
  }

  public InputStream getUnicodeStream(String columnLabel) throws SQLException {
    return realResultSet.getUnicodeStream(columnLabel);
  }

  public InputStream getBinaryStream(String columnLabel) throws SQLException {
    return realResultSet.getBinaryStream(columnLabel);
  }

  public SQLWarning getWarnings() throws SQLException {
    return realResultSet.getWarnings();
  }

  public void clearWarnings() throws SQLException {
    realResultSet.clearWarnings();
  }

  public String getCursorName() throws SQLException {
    return realResultSet.getCursorName();
  }

  public ResultSetMetaData getMetaData() throws SQLException {
    return realResultSet.getMetaData();
  }

  public Object getObject(int columnIndex) throws SQLException {
    return realResultSet.getObject(columnIndex);
  }

  public Object getObject(String columnLabel) throws SQLException {
    return realResultSet.getObject(columnLabel);
  }

  public int findColumn(String columnLabel) throws SQLException {
    return realResultSet.findColumn(columnLabel);
  }

  public Reader getCharacterStream(int columnIndex) throws SQLException {
    return realResultSet.getCharacterStream(columnIndex);
  }

  public Reader getCharacterStream(String columnLabel) throws SQLException {
    return realResultSet.getCharacterStream(columnLabel);
  }

  public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
    return realResultSet.getBigDecimal(columnIndex);
  }

  public BigDecimal getBigDecimal(String columnLabel) throws SQLException {
    return realResultSet.getBigDecimal(columnLabel);
  }

  public boolean isBeforeFirst() throws SQLException {
    return realResultSet.isBeforeFirst();
  }

  public boolean isAfterLast() throws SQLException {
    return realResultSet.isAfterLast();
  }

  public boolean isFirst() throws SQLException {
    return realResultSet.isFirst();
  }

  public boolean isLast() throws SQLException {
    return realResultSet.isLast();
  }

  public void beforeFirst() throws SQLException {
    realResultSet.beforeFirst();
  }

  public void afterLast() throws SQLException {
    realResultSet.afterLast();
  }

  public boolean first() throws SQLException {
    return realResultSet.first();
  }

  public boolean last() throws SQLException {
    return realResultSet.last();
  }

  public int getRow() throws SQLException {
    return realResultSet.getRow();
  }

  public boolean absolute(int row) throws SQLException {
    return realResultSet.absolute(row);
  }

  public boolean relative(int rows) throws SQLException {
    return realResultSet.relative(rows);
  }

  public boolean previous() throws SQLException {
    return realResultSet.previous();
  }

  public void setFetchDirection(int direction) throws SQLException {
    realResultSet.setFetchDirection(direction);
  }

  public int getFetchDirection() throws SQLException {
    return realResultSet.getFetchDirection();
  }

  public void setFetchSize(int rows) throws SQLException {
    realResultSet.setFetchSize(rows);
  }

  public int getFetchSize() throws SQLException {
    return realResultSet.getFetchSize();
  }

  public int getType() throws SQLException {
    return realResultSet.getType();
  }

  public int getConcurrency() throws SQLException {
    return realResultSet.getConcurrency();
  }

  public boolean rowUpdated() throws SQLException {
    return realResultSet.rowUpdated();
  }

  public boolean rowInserted() throws SQLException {
    return realResultSet.rowInserted();
  }

  public boolean rowDeleted() throws SQLException {
    return realResultSet.rowDeleted();
  }

  public void updateNull(int columnIndex) throws SQLException {
    realResultSet.updateNull(columnIndex);
  }

  public void updateBoolean(int columnIndex, boolean x) throws SQLException {
    realResultSet.updateBoolean(columnIndex, x);
  }

  public void updateByte(int columnIndex, byte x) throws SQLException {
    realResultSet.updateByte(columnIndex, x);
  }

  public void updateShort(int columnIndex, short x) throws SQLException {
    realResultSet.updateShort(columnIndex, x);
  }

  public void updateInt(int columnIndex, int x) throws SQLException {
    realResultSet.updateInt(columnIndex, x);
  }

  public void updateLong(int columnIndex, long x) throws SQLException {
    realResultSet.updateLong(columnIndex, x);
  }

  public void updateFloat(int columnIndex, float x) throws SQLException {
    realResultSet.updateFloat(columnIndex, x);
  }

  public void updateDouble(int columnIndex, double x) throws SQLException {
    realResultSet.updateDouble(columnIndex, x);
  }

  public void updateBigDecimal(int columnIndex, BigDecimal x) throws SQLException {
    realResultSet.updateBigDecimal(columnIndex, x);
  }

  public void updateString(int columnIndex, String x) throws SQLException {
    realResultSet.updateString(columnIndex, x);
  }

  public void updateBytes(int columnIndex, byte[] x) throws SQLException {
    realResultSet.updateBytes(columnIndex, x);
  }

  public void updateDate(int columnIndex, Date x) throws SQLException {
    realResultSet.updateDate(columnIndex, x);
  }

  public void updateTime(int columnIndex, Time x) throws SQLException {
    realResultSet.updateTime(columnIndex, x);
  }

  public void updateTimestamp(int columnIndex, Timestamp x) throws SQLException {
    realResultSet.updateTimestamp(columnIndex, x);
  }

  public void updateAsciiStream(int columnIndex, InputStream x, int length) throws SQLException {
    realResultSet.updateAsciiStream(columnIndex, x, length);
  }

  public void updateBinaryStream(int columnIndex, InputStream x, int length) throws SQLException {
    realResultSet.updateBinaryStream(columnIndex, x, length);
  }

  public void updateCharacterStream(int columnIndex, Reader x, int length) throws SQLException {
    realResultSet.updateCharacterStream(columnIndex, x, length);
  }

  public void updateObject(int columnIndex, Object x, int scaleOrLength) throws SQLException {
    realResultSet.updateObject(columnIndex, x, scaleOrLength);
  }

  public void updateObject(int columnIndex, Object x) throws SQLException {
    realResultSet.updateObject(columnIndex, x);
  }

  public void updateNull(String columnLabel) throws SQLException {
    realResultSet.updateNull(columnLabel);
  }

  public void updateBoolean(String columnLabel, boolean x) throws SQLException {
    realResultSet.updateBoolean(columnLabel, x);
  }

  public void updateByte(String columnLabel, byte x) throws SQLException {
    realResultSet.updateByte(columnLabel, x);
  }

  public void updateShort(String columnLabel, short x) throws SQLException {
    realResultSet.updateShort(columnLabel, x);
  }

  public void updateInt(String columnLabel, int x) throws SQLException {
    realResultSet.updateInt(columnLabel, x);
  }

  public void updateLong(String columnLabel, long x) throws SQLException {
    realResultSet.updateLong(columnLabel, x);
  }

  public void updateFloat(String columnLabel, float x) throws SQLException {
    realResultSet.updateFloat(columnLabel, x);
  }

  public void updateDouble(String columnLabel, double x) throws SQLException {
    realResultSet.updateDouble(columnLabel, x);
  }

  public void updateBigDecimal(String columnLabel, BigDecimal x) throws SQLException {
    realResultSet.updateBigDecimal(columnLabel, x);
  }

  public void updateString(String columnLabel, String x) throws SQLException {
    realResultSet.updateString(columnLabel, x);
  }

  public void updateBytes(String columnLabel, byte[] x) throws SQLException {
    realResultSet.updateBytes(columnLabel, x);
  }

  public void updateDate(String columnLabel, Date x) throws SQLException {
    realResultSet.updateDate(columnLabel, x);
  }

  public void updateTime(String columnLabel, Time x) throws SQLException {
    realResultSet.updateTime(columnLabel, x);
  }

  public void updateTimestamp(String columnLabel, Timestamp x) throws SQLException {
    realResultSet.updateTimestamp(columnLabel, x);
  }

  public void updateAsciiStream(String columnLabel, InputStream x, int length) throws SQLException {
    realResultSet.updateAsciiStream(columnLabel, x, length);
  }

  public void updateBinaryStream(String columnLabel, InputStream x, int length) throws SQLException {
    realResultSet.updateBinaryStream(columnLabel, x, length);
  }

  public void updateCharacterStream(String columnLabel, Reader reader, int length) throws SQLException {
    realResultSet.updateCharacterStream(columnLabel, reader, length);
  }

  public void updateObject(String columnLabel, Object x, int scaleOrLength) throws SQLException {
    realResultSet.updateObject(columnLabel, x, scaleOrLength);
  }

  public void updateObject(String columnLabel, Object x) throws SQLException {
    realResultSet.updateObject(columnLabel, x);
  }

  public void insertRow() throws SQLException {
    realResultSet.insertRow();
  }

  public void updateRow() throws SQLException {
    realResultSet.updateRow();
  }

  public void deleteRow() throws SQLException {
    realResultSet.deleteRow();
  }

  public void refreshRow() throws SQLException {
    realResultSet.refreshRow();
  }

  public void cancelRowUpdates() throws SQLException {
    realResultSet.cancelRowUpdates();
  }

  public void moveToInsertRow() throws SQLException {
    realResultSet.moveToInsertRow();
  }

  public void moveToCurrentRow() throws SQLException {
    realResultSet.moveToCurrentRow();
  }

  public Statement getStatement() throws SQLException {
    return realResultSet.getStatement();
  }

  public Object getObject(int columnIndex, Map<String, Class<?>> map) throws SQLException {
    return realResultSet.getObject(columnIndex, map);
  }

  public Ref getRef(int columnIndex) throws SQLException {
    return realResultSet.getRef(columnIndex);
  }

  public Blob getBlob(int columnIndex) throws SQLException {
    return realResultSet.getBlob(columnIndex);
  }

  public Clob getClob(int columnIndex) throws SQLException {
    return realResultSet.getClob(columnIndex);
  }

  public Array getArray(int columnIndex) throws SQLException {
    return realResultSet.getArray(columnIndex);
  }

  public Object getObject(String columnLabel, Map<String, Class<?>> map) throws SQLException {
    return realResultSet.getObject(columnLabel, map);
  }

  public Ref getRef(String columnLabel) throws SQLException {
    return realResultSet.getRef(columnLabel);
  }

  public Blob getBlob(String columnLabel) throws SQLException {
    return realResultSet.getBlob(columnLabel);
  }

  public Clob getClob(String columnLabel) throws SQLException {
    return realResultSet.getClob(columnLabel);
  }

  public Array getArray(String columnLabel) throws SQLException {
    return realResultSet.getArray(columnLabel);
  }

  public URL getURL(int columnIndex) throws SQLException {
    return realResultSet.getURL(columnIndex);
  }

  public URL getURL(String columnLabel) throws SQLException {
    return realResultSet.getURL(columnLabel);
  }

  public void updateRef(int columnIndex, Ref x) throws SQLException {
    realResultSet.updateRef(columnIndex, x);
  }

  public void updateRef(String columnLabel, Ref x) throws SQLException {
    realResultSet.updateRef(columnLabel, x);
  }

  public void updateBlob(int columnIndex, Blob x) throws SQLException {
    realResultSet.updateBlob(columnIndex, x);
  }

  public void updateBlob(String columnLabel, Blob x) throws SQLException {
    realResultSet.updateBlob(columnLabel, x);
  }

  public void updateClob(int columnIndex, Clob x) throws SQLException {
    realResultSet.updateClob(columnIndex, x);
  }

  public void updateClob(String columnLabel, Clob x) throws SQLException {
    realResultSet.updateClob(columnLabel, x);
  }

  public void updateArray(int columnIndex, Array x) throws SQLException {
    realResultSet.updateArray(columnIndex, x);
  }

  public void updateArray(String columnLabel, Array x) throws SQLException {
    realResultSet.updateArray(columnLabel, x);
  }

  public RowId getRowId(int columnIndex) throws SQLException {
    return realResultSet.getRowId(columnIndex);
  }

  public RowId getRowId(String columnLabel) throws SQLException {
    return realResultSet.getRowId(columnLabel);
  }

  public void updateRowId(int columnIndex, RowId x) throws SQLException {
    realResultSet.updateRowId(columnIndex, x);
  }

  public void updateRowId(String columnLabel, RowId x) throws SQLException {
    realResultSet.updateRowId(columnLabel, x);
  }

  public int getHoldability() throws SQLException {
    return realResultSet.getHoldability();
  }

  public boolean isClosed() throws SQLException {
    return realResultSet.isClosed();
  }

  public void updateNString(int columnIndex, String nString) throws SQLException {
    realResultSet.updateNString(columnIndex, nString);
  }

  public void updateNString(String columnLabel, String nString) throws SQLException {
    realResultSet.updateNString(columnLabel, nString);
  }

  public void updateNClob(int columnIndex, NClob nClob) throws SQLException {
    realResultSet.updateNClob(columnIndex, nClob);
  }

  public void updateNClob(String columnLabel, NClob nClob) throws SQLException {
    realResultSet.updateNClob(columnLabel, nClob);
  }

  public NClob getNClob(int columnIndex) throws SQLException {
    return realResultSet.getNClob(columnIndex);
  }

  public NClob getNClob(String columnLabel) throws SQLException {
    return realResultSet.getNClob(columnLabel);
  }

  public SQLXML getSQLXML(int columnIndex) throws SQLException {
    return realResultSet.getSQLXML(columnIndex);
  }

  public SQLXML getSQLXML(String columnLabel) throws SQLException {
    return realResultSet.getSQLXML(columnLabel);
  }

  public void updateSQLXML(int columnIndex, SQLXML xmlObject) throws SQLException {
    realResultSet.updateSQLXML(columnIndex, xmlObject);
  }

  public void updateSQLXML(String columnLabel, SQLXML xmlObject) throws SQLException {
    realResultSet.updateSQLXML(columnLabel, xmlObject);
  }

  public String getNString(int columnIndex) throws SQLException {
    return realResultSet.getNString(columnIndex);
  }

  public String getNString(String columnLabel) throws SQLException {
    return realResultSet.getNString(columnLabel);
  }

  public Reader getNCharacterStream(int columnIndex) throws SQLException {
    return realResultSet.getNCharacterStream(columnIndex);
  }

  public Reader getNCharacterStream(String columnLabel) throws SQLException {
    return realResultSet.getNCharacterStream(columnLabel);
  }

  public void updateNCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
    realResultSet.updateNCharacterStream(columnIndex, x, length);
  }

  public void updateNCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
    realResultSet.updateNCharacterStream(columnLabel, reader, length);
  }

  public void updateAsciiStream(int columnIndex, InputStream x, long length) throws SQLException {
    realResultSet.updateAsciiStream(columnIndex, x, length);
  }

  public void updateBinaryStream(int columnIndex, InputStream x, long length) throws SQLException {
    realResultSet.updateBinaryStream(columnIndex, x, length);
  }

  public void updateCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
    realResultSet.updateCharacterStream(columnIndex, x, length);
  }

  public void updateAsciiStream(String columnLabel, InputStream x, long length) throws SQLException {
    realResultSet.updateAsciiStream(columnLabel, x, length);
  }

  public void updateBinaryStream(String columnLabel, InputStream x, long length) throws SQLException {
    realResultSet.updateBinaryStream(columnLabel, x, length);
  }

  public void updateCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
    realResultSet.updateCharacterStream(columnLabel, reader, length);
  }

  public void updateBlob(int columnIndex, InputStream inputStream, long length) throws SQLException {
    realResultSet.updateBlob(columnIndex, inputStream, length);
  }

  public void updateBlob(String columnLabel, InputStream inputStream, long length) throws SQLException {
    realResultSet.updateBlob(columnLabel, inputStream, length);
  }

  public void updateClob(int columnIndex, Reader reader, long length) throws SQLException {
    realResultSet.updateClob(columnIndex, reader, length);
  }

  public void updateClob(String columnLabel, Reader reader, long length) throws SQLException {
    realResultSet.updateClob(columnLabel, reader, length);
  }

  public void updateNClob(int columnIndex, Reader reader, long length) throws SQLException {
    realResultSet.updateNClob(columnIndex, reader, length);
  }

  public void updateNClob(String columnLabel, Reader reader, long length) throws SQLException {
    realResultSet.updateNClob(columnLabel, reader, length);
  }

  public void updateNCharacterStream(int columnIndex, Reader x) throws SQLException {
    realResultSet.updateNCharacterStream(columnIndex, x);
  }

  public void updateNCharacterStream(String columnLabel, Reader reader) throws SQLException {
    realResultSet.updateNCharacterStream(columnLabel, reader);
  }

  public void updateAsciiStream(int columnIndex, InputStream x) throws SQLException {
    realResultSet.updateAsciiStream(columnIndex, x);
  }

  public void updateBinaryStream(int columnIndex, InputStream x) throws SQLException {
    realResultSet.updateBinaryStream(columnIndex, x);
  }

  public void updateCharacterStream(int columnIndex, Reader x) throws SQLException {
    realResultSet.updateCharacterStream(columnIndex, x);
  }

  public void updateAsciiStream(String columnLabel, InputStream x) throws SQLException {
    realResultSet.updateAsciiStream(columnLabel, x);
  }

  public void updateBinaryStream(String columnLabel, InputStream x) throws SQLException {
    realResultSet.updateBinaryStream(columnLabel, x);
  }

  public void updateCharacterStream(String columnLabel, Reader reader) throws SQLException {
    realResultSet.updateCharacterStream(columnLabel, reader);
  }

  public void updateBlob(int columnIndex, InputStream inputStream) throws SQLException {
    realResultSet.updateBlob(columnIndex, inputStream);
  }

  public void updateBlob(String columnLabel, InputStream inputStream) throws SQLException {
    realResultSet.updateBlob(columnLabel, inputStream);
  }

  public void updateClob(int columnIndex, Reader reader) throws SQLException {
    realResultSet.updateClob(columnIndex, reader);
  }

  public void updateClob(String columnLabel, Reader reader) throws SQLException {
    realResultSet.updateClob(columnLabel, reader);
  }

  public void updateNClob(int columnIndex, Reader reader) throws SQLException {
    realResultSet.updateNClob(columnIndex, reader);
  }

  public void updateNClob(String columnLabel, Reader reader) throws SQLException {
    realResultSet.updateNClob(columnLabel, reader);
  }

  public <T> T getObject(int columnIndex, Class<T> type) throws SQLException {
    return realResultSet.getObject(columnIndex, type);
  }

  public <T> T getObject(String columnLabel, Class<T> type) throws SQLException {
    return realResultSet.getObject(columnLabel, type);
  }

  public <T> T unwrap(Class<T> iface) throws SQLException {
    return realResultSet.unwrap(iface);
  }

  public boolean isWrapperFor(Class<?> iface) throws SQLException {
    return realResultSet.isWrapperFor(iface);
  }
}
