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
public class JiaoxueFileMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "com.hao.schoa.po.map.JiaoxueFileMapBuilder";

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

        dbMap.addTable("jiaoxue_file");
        TableMap tMap = dbMap.getTable("jiaoxue_file");
        tMap.setJavaName("JiaoxueFile");
        tMap.setOMClass( com.hao.schoa.po.JiaoxueFile.class );
        tMap.setPeerClass( com.hao.schoa.po.JiaoxueFilePeer.class );
        tMap.setPrimaryKeyMethod(TableMap.NATIVE);
        DB dbAdapter = Torque.getDB("schoa");
        if (dbAdapter.getIDMethodType().equals(DB.SEQUENCE))
        {
            tMap.setPrimaryKeyMethodInfo("jiaoxue_file_SEQ");
        }
        else if (dbAdapter.getIDMethodType().equals(DB.AUTO_INCREMENT))
        {
            tMap.setPrimaryKeyMethodInfo("jiaoxue_file");
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
  // ------------- Column: xueqi_id --------------------
        cMap = new ColumnMap( "xueqi_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "XueqiId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("学期id");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(2);
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
        cMap.setPosition(3);
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
        cMap.setDescription("教师id");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(4);
        tMap.addColumn(cMap);
  // ------------- Column: file_flag --------------------
        cMap = new ColumnMap( "file_flag", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "FileFlag" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("文件标识");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(5);
        tMap.addColumn(cMap);
  // ------------- Column: file_score --------------------
        cMap = new ColumnMap( "file_score", tMap);
        cMap.setType( new Double(0) );
        cMap.setTorqueType( "DOUBLE" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "FileScore" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("文件得分");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(6);
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
        cMap.setDescription("文件原名");
        cMap.setInheritance("false");
        cMap.setSize( 100 );
        cMap.setPosition(7);
        tMap.addColumn(cMap);
  // ------------- Column: save_name --------------------
        cMap = new ColumnMap( "save_name", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "SaveName" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("文件保存名");
        cMap.setInheritance("false");
        cMap.setSize( 100 );
        cMap.setPosition(8);
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
        cMap.setPosition(9);
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
        cMap.setPosition(10);
        tMap.addColumn(cMap);
  // ------------- Column: member_id --------------------
        cMap = new ColumnMap( "member_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "MemberId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("上传人");
        cMap.setInheritance("false");
        cMap.setPosition(11);
        tMap.addColumn(cMap);
  // ------------- Column: member_name --------------------
        cMap = new ColumnMap( "member_name", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "MemberName" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("上传人");
        cMap.setInheritance("false");
        cMap.setSize( 50 );
        cMap.setPosition(12);
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
        cMap.setPosition(13);
        tMap.addColumn(cMap);
        tMap.setUseInheritance(false);
    }
}
