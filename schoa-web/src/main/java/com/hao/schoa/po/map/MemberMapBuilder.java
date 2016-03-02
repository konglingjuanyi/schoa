package com.hao.schoa.po.map;

import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.adapter.DB;
import org.apache.torque.map.ColumnMap;
import org.apache.torque.map.DatabaseMap;
import org.apache.torque.map.MapBuilder;
import org.apache.torque.map.TableMap;

/**
  */
public class MemberMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "com.hao.schoa.po.map.MemberMapBuilder";

    /**
     * The database map.
     */
    private DatabaseMap dbMap = null;

    /**
     * Tells us if this DatabaseMapBuilder is built so that we
     * don't have to re-build it every time.
     *
     * @return true if this DatabaseMapBuilder is built
     */
    public boolean isBuilt()
    {
        return (dbMap != null);
    }

    /**
     * Gets the databasemap this map builder built.
     *
     * @return the databasemap
     */
    public DatabaseMap getDatabaseMap()
    {
        return this.dbMap;
    }

    /**
     * The doBuild() method builds the DatabaseMap
     *
     * @throws TorqueException
     */
    public synchronized void doBuild() throws TorqueException
    {
        if ( isBuilt() ) {
            return;
        }
        dbMap = Torque.getDatabaseMap("schoa");

        dbMap.addTable("member");
        TableMap tMap = dbMap.getTable("member");
        tMap.setJavaName("Member");
        tMap.setOMClass( com.hao.schoa.po.Member.class );
        tMap.setPeerClass( com.hao.schoa.po.MemberPeer.class );
        tMap.setPrimaryKeyMethod(TableMap.NATIVE);
        DB dbAdapter = Torque.getDB("schoa");
        if (dbAdapter.getIDMethodType().equals(DB.SEQUENCE))
        {
            tMap.setPrimaryKeyMethodInfo("member_SEQ");
        }
        else if (dbAdapter.getIDMethodType().equals(DB.AUTO_INCREMENT))
        {
            tMap.setPrimaryKeyMethodInfo("member");
        }

        ColumnMap cMap = null;


  // ------------- Column: id --------------------
        cMap = new ColumnMap( "id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(true);
        cMap.setNotNull(true);
        cMap.setJavaName( "Id" );
        cMap.setAutoIncrement(true);
        cMap.setProtected(false);
        cMap.setDescription("");
        cMap.setInheritance("false");
        cMap.setPosition(1);
        tMap.addColumn(cMap);
  // ------------- Column: name --------------------
        cMap = new ColumnMap( "name", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Name" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("登录名");
        cMap.setInheritance("false");
        cMap.setSize( 50 );
        cMap.setPosition(2);
        tMap.addColumn(cMap);
  // ------------- Column: valid --------------------
        cMap = new ColumnMap( "valid", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Valid" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("0有效，1禁用");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(3);
        tMap.addColumn(cMap);
  // ------------- Column: pwd --------------------
        cMap = new ColumnMap( "pwd", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Pwd" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("密码");
        cMap.setInheritance("false");
        cMap.setSize( 32 );
        cMap.setPosition(4);
        tMap.addColumn(cMap);
  // ------------- Column: show_name --------------------
        cMap = new ColumnMap( "show_name", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ShowName" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("显示名");
        cMap.setInheritance("false");
        cMap.setSize( 50 );
        cMap.setPosition(5);
        tMap.addColumn(cMap);
  // ------------- Column: role_id --------------------
        cMap = new ColumnMap( "role_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "RoleId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("角色id");
        cMap.setInheritance("false");
        cMap.setPosition(6);
        tMap.addColumn(cMap);
  // ------------- Column: phone --------------------
        cMap = new ColumnMap( "phone", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Phone" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("电话");
        cMap.setInheritance("false");
        cMap.setSize( 20 );
        cMap.setPosition(7);
        tMap.addColumn(cMap);
  // ------------- Column: email --------------------
        cMap = new ColumnMap( "email", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Email" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("");
        cMap.setInheritance("false");
        cMap.setSize( 50 );
        cMap.setPosition(8);
        tMap.addColumn(cMap);
  // ------------- Column: teacher_id --------------------
        cMap = new ColumnMap( "teacher_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "TeacherId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("关联教师");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(9);
        tMap.addColumn(cMap);
        tMap.setUseInheritance(false);
    }
}
