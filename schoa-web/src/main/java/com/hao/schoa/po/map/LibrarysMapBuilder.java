package com.hao.schoa.po.map;

import java.util.Date;

import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.adapter.DB;
import org.apache.torque.map.ColumnMap;
import org.apache.torque.map.DatabaseMap;
import org.apache.torque.map.MapBuilder;
import org.apache.torque.map.TableMap;

/**
  */
public class LibrarysMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "com.hao.schoa.po.map.LibrarysMapBuilder";

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

        dbMap.addTable("librarys");
        TableMap tMap = dbMap.getTable("librarys");
        tMap.setJavaName("Librarys");
        tMap.setOMClass( com.hao.schoa.po.Librarys.class );
        tMap.setPeerClass( com.hao.schoa.po.LibrarysPeer.class );
        tMap.setPrimaryKeyMethod(TableMap.NATIVE);
        DB dbAdapter = Torque.getDB("schoa");
        if (dbAdapter.getIDMethodType().equals(DB.SEQUENCE))
        {
            tMap.setPrimaryKeyMethodInfo("librarys_SEQ");
        }
        else if (dbAdapter.getIDMethodType().equals(DB.AUTO_INCREMENT))
        {
            tMap.setPrimaryKeyMethodInfo("librarys");
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
        cMap.setNotNull(true);
        cMap.setJavaName( "Name" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("文件原名");
        cMap.setInheritance("false");
        cMap.setSize( 100 );
        cMap.setPosition(2);
        tMap.addColumn(cMap);
  // ------------- Column: save_name --------------------
        cMap = new ColumnMap( "save_name", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(true);
        cMap.setJavaName( "SaveName" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("文件保存名");
        cMap.setInheritance("false");
        cMap.setSize( 100 );
        cMap.setPosition(3);
        tMap.addColumn(cMap);
  // ------------- Column: kecheng_id --------------------
        cMap = new ColumnMap( "kecheng_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "KechengId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("课程id");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(4);
        tMap.addColumn(cMap);
  // ------------- Column: intro --------------------
        cMap = new ColumnMap( "intro", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Intro" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("文件描述");
        cMap.setInheritance("false");
        cMap.setSize( 300 );
        cMap.setPosition(5);
        tMap.addColumn(cMap);
  // ------------- Column: file_size --------------------
        cMap = new ColumnMap( "file_size", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "FileSize" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("文件大小");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(6);
        tMap.addColumn(cMap);
  // ------------- Column: man --------------------
        cMap = new ColumnMap( "man", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Man" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("上传人");
        cMap.setInheritance("false");
        cMap.setSize( 50 );
        cMap.setPosition(7);
        tMap.addColumn(cMap);
  // ------------- Column: uptime --------------------
        cMap = new ColumnMap( "uptime", tMap);
        cMap.setType( new Date() );
        cMap.setTorqueType( "TIMESTAMP" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Uptime" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("上传时间");
        cMap.setInheritance("false");
        cMap.setPosition(8);
        tMap.addColumn(cMap);
        tMap.setUseInheritance(false);
    }
}
