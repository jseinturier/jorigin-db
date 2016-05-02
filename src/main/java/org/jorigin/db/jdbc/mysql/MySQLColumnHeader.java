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
package org.jorigin.db.jdbc.mysql;

import org.jorigin.db.jdbc.ColumnHeader;




/**
 * A column header for MySQL databases.
 * @author Julien Seinturier - (c) 2009 - JOrigin project - <a href="http://www.jorigin.org">http:/www.jorigin.org</a>
 * @since 1.0.0
 * @version 1.0.1
 */
public class MySQLColumnHeader extends ColumnHeader {

  
  private int numericPrecision = 0;
  private int numericScale     = 0;
  
  private String extra         = null;
  private String privileges    = null;
  
  /**
   * Create a new MySQL column header with all metadata given.
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
   * @param numericPrecision the precision of numeric values.
   * @param numericScale the scale of numeric values.
   * @param columnKey the key of the column.
   * @param extra extra parameters
   * @param privileges the privilege of the column.
   */
  public MySQLColumnHeader(String name, int type, String typeName, int columnSize, 
      int decimalDigits, int nullable, String remarks, String defaultValue,
      int charOctetLength, int ordinalPosition, String isNullable,
      String autoIncrement, int numericPrecision,
      int numericScale, String columnKey, String extra, String privileges){
    super(name, type, typeName, columnSize, 
        decimalDigits, nullable, remarks, defaultValue,
        charOctetLength, ordinalPosition, isNullable,
        autoIncrement, columnKey);
    
    this.numericPrecision = numericPrecision;
    this.numericScale     = numericScale;
    this.extra            = extra;
    this.privileges       = privileges;
  }
  
  
  /**
   * Get the numeric precision of the column
   * @return  the numeric precision of the column
   */
  public int getNumericPrecision(){
    return numericPrecision;
  }
  
  /**
   * Get the numeric scale of the column
   * @return the numeric scale of the column
   */
  public int getNumericScale(){
    return numericScale;
  }
  
  
  /**
   * Get the extra of the column
   * @return the extra of the column
   */
  public String getExtra(){
    return extra;
  }
  
  /**
   * Get the privileges of the column
   * @return the privileges of the column
   */
  public String getPrivileges(){
    return privileges;  
  }
  
  
}
