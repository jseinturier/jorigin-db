/*
  This file is part of JOrigin Common Library.

    JOrigin Common is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    JOrigin Common is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with JOrigin Common.  If not, see <http://www.gnu.org/licenses/>.
    
*/
package org.jorigin.db.jdbc;


/**
 * A database column header.
 * @author Julien Seinturier - (c) 2009 - JOrigin project - <a href="http://www.jorigin.org">http:/www.jorigin.org</a>
 * @since 1.0.0
 * @version 1.0.1
 */
public class ColumnHeader {
  
  /**
   * This  string represent a primary key
   */
  public static final String KEY_PRIMARY = "PRI";
  
  /**
   * This string represent a unique key
   */
  public static final String KEY_UNIQUE  = "UNI";
  
  /**
   * This string represent a multiple key
   */
  public static final String KEY_MUL     = "MUL";
  
  /**
   * The column name
   */
  private String name       = null;
  
  /**
   * The column type
   */
  private int type          = -1;
  
  /**
   * The column type name
   */
  private String typeName   = null;
  
  /**
   * The  column size.  
   */
  private int columnSize    = -1;
  
  /**
   * The number of fractional digits. Null is returned for data types where  
   * DECIMAL_DIGITS is not applicable.
   */
  private int decimalDigits = 0;
  
  /**
   * <B>NULLABLE</B> specifies if NULL allowed. Value can be:
   *      <UL>
   *      <LI> columnNoNulls - might not allow <code>NULL</code> values
   *      <LI> columnNullable - definitely allows <code>NULL</code> values
   *      <LI> columnNullableUnknown - nullability unknown
   *      </UL>
   */
  private int nullable      = 0;
  
  /**
   * Comment describing column (may be <code>null</code>)
   */
  private String remarks    = null;

  /**
   * Default value for the column, which should be interpreted as a string when the value is 
   * enclosed in single quotes (may be <code>null</code>)
   */
  private String defaultValue = null;
  
  
  /**
   * For char types the maximum number of bytes in the column
   */
  private int charOctetLength = 0;
  
  /**
   * index of column in table 
   *      (starting at 1)
   */
  private int ordinalPosition = 0;
  
  /**
   * <B>IS_NULLABLE</B> String  => ISO rules are used to determine the nullability for a column.
   *       <UL>
   *       <LI> YES           --- if the parameter can include NULLs
   *       <LI> NO            --- if the parameter cannot include NULLs
   *       <LI> empty string  --- if the nullability for the 
   * parameter is unknown
   *       </UL>
   */
  private String isNullable = "";
  
  /**
   * <B>IS_AUTOINCREMENT</B> Indicates whether this column is auto incremented
   *       <UL>
   *       <LI> YES           --- if the column is auto incremented
   *       <LI> NO            --- if the column is not auto incremented
   *       <LI> empty string  --- if it cannot be determined whether the column is auto incremented
   * parameter is unknown
   *       </UL>
   */
  private String autoIncrement = "";
  
  /**
   * The key associated to the column
   */
  private String columnKey     = null;
  
  /**
   * Create a new column header with all metadata given.
   * @param name name the name of the column.
   * @param type the type of the column.
   * @param typeName the name of the type.
   * @param columnSize the size of the column.
   * @param decimalDigits the number of decimal digits used by this column.
   * @param nullable the <code>Nullable</code> attribute of the column.
   * @param remarks the remarks attached to this column.
   * @param defaultValue the default value of the column.
   * @param charOctetLength the maximum number of bytes for char types within the column.
   * @param ordinalPosition the position of the column within the table.
   * @param isNullable <code>true</code> if the column is <code>Nullable</code> and <code>false</code> otherwise.
   * @param autoIncrement the auto increment status for the column.
   * @param columnKey the key of the column.
   */
  public ColumnHeader(String name, int type, String typeName, int columnSize, 
                      int decimalDigits, int nullable, String remarks, String defaultValue,
                      int charOctetLength, int ordinalPosition, String isNullable,
                      String autoIncrement, String columnKey){
    
    this.name            = name;
    
    this.type            = type;
    
    this.typeName        = typeName;
    
    this.columnSize      = columnSize;
    
    this.decimalDigits   = decimalDigits;
     
    this.nullable        = nullable;
    
    this.remarks         = remarks;
    
    this.defaultValue    = defaultValue;
    
    this.charOctetLength = charOctetLength;
    
    this.ordinalPosition = ordinalPosition;
    
    this.isNullable      = isNullable;
    
    this.autoIncrement   = autoIncrement;
    
    this.columnKey       = columnKey;
  }
  
  /**
   * Create a new column header with a name and a type given in parameter
   * @param name the name of the column.
   * @param type the type of the column.
   */
  public ColumnHeader(String name, int type){
    this.name = name;
    this.type = type;
  }
  
  @Override
  public String toString(){
    return name+" ("+typeName+")";
  }
  
  /**
   * Get the name of the column.
   * @return the name of the column.
   */
  public String getName(){
    return name;
  }
  
  /**
   * Get the type of the column.
   * @return the type of the column.
   */
  public int getType(){
    return type;
  }
  
  /**
   * Get the name of the type.
   * @return the name of the type.
   * @see #getType()
   */
  public String getTypeName(){
    return typeName;
  }
  
  /**
   * Get the size of the column.
   * @return the size of the column.
   */
  public int getColumnSize(){
    return columnSize;
  }
  
  /**
   * Get the number of decimal digits used by this column.
   * @return the number of decimal digits used by this column.
   */
  public int getDecimalDigits(){
    return decimalDigits;
  }
   
  /**
   * Get the <code>Nullable</code> attribute of the column. The returned value can be:<br>
   * <UL>
   *   <LI> columnNoNulls - might not allow <code>NULL</code> values
   *   <LI> columnNullable - definitely allows <code>NULL</code> values
   *   <LI> columnNullableUnknown - nullability unknown
   * </UL>
   * @return the <code>Nullable</code> attribute of the column.
   */
  public int getNullable(){
    return nullable;
  }
  
  /**
   * Get the remarks attached to this column (may be <code>null</code>).
   * @return the remarks attached to this column.
   */
  public String getRemarks(){
    return remarks;
  }
  
  /**
   * Get the default value of the column (may be <code>null</code>).
   * @return the default value of the column.
   */
  public String getDefaultValue(){
    return defaultValue;
  }
  
  /**
   * Get the maximum number of bytes for char types within the column.
   * @return the maximum number of bytes for char types within the column.
   */
  public int getCharOctetLength(){
    return charOctetLength;
  }
  
  /**
   * Get the position of the column within the table.
   * @return the position of the column within the table.
   */
  public int getOrdinalPosition(){
    return ordinalPosition;
  }
  
  /**
   * Get if the column is <code>Nullable</code>. The returned value can be:<br>
   * <ul>
   * <li> YES if the column can include NULL values;
   * <li> NO if the column cannot include NULL values;
   * <li> an empty string if NULL capability cannot be determined.
   * </ul>
   * @return <code>true</code> if the column is <code>Nullable</code> and <code>false</code> otherwise.
   */
  public String isNullable(){
    return isNullable;
  }
  
  /**
   * Get the auto increment status for the column. The status can be:<br>
   * <ul>
   * <li> YES if the column is auto incremented;
   * <li> NO if the column is not incremented;
   * <li> an empty string if the auto increment cannot be determined.
   * </ul>
   * @return the auto increment status for the column.
   */
  public String getAutoIncrement(){
    return autoIncrement;
  }
  
  /**
   * Get the key associated to the column.
   * @return the key associated to the column.
   */
  public String getColumnKey(){
    return columnKey;
  }
}
