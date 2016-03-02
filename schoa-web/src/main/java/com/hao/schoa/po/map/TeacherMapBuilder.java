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
public class TeacherMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "com.hao.schoa.po.map.TeacherMapBuilder";

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

        dbMap.addTable("teacher");
        TableMap tMap = dbMap.getTable("teacher");
        tMap.setJavaName("Teacher");
        tMap.setOMClass( com.hao.schoa.po.Teacher.class );
        tMap.setPeerClass( com.hao.schoa.po.TeacherPeer.class );
        tMap.setPrimaryKeyMethod(TableMap.NATIVE);
        DB dbAdapter = Torque.getDB("schoa");
        if (dbAdapter.getIDMethodType().equals(DB.SEQUENCE))
        {
            tMap.setPrimaryKeyMethodInfo("teacher_SEQ");
        }
        else if (dbAdapter.getIDMethodType().equals(DB.AUTO_INCREMENT))
        {
            tMap.setPrimaryKeyMethodInfo("teacher");
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
        cMap.setDescription("教师名称");
        cMap.setInheritance("false");
        cMap.setSize( 100 );
        cMap.setPosition(2);
        tMap.addColumn(cMap);
  // ------------- Column: code --------------------
        cMap = new ColumnMap( "code", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Code" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("教师编号");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(3);
        tMap.addColumn(cMap);
  // ------------- Column: sex --------------------
        cMap = new ColumnMap( "sex", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Sex" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("性别");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(4);
        tMap.addColumn(cMap);
  // ------------- Column: birthday --------------------
        cMap = new ColumnMap( "birthday", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Birthday" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("生日");
        cMap.setInheritance("false");
        cMap.setSize( 20 );
        cMap.setPosition(5);
        tMap.addColumn(cMap);
  // ------------- Column: married --------------------
        cMap = new ColumnMap( "married", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Married" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("婚否");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(6);
        tMap.addColumn(cMap);
  // ------------- Column: hometown --------------------
        cMap = new ColumnMap( "hometown", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Hometown" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("籍贯");
        cMap.setInheritance("false");
        cMap.setSize( 200 );
        cMap.setPosition(7);
        tMap.addColumn(cMap);
  // ------------- Column: graduated --------------------
        cMap = new ColumnMap( "graduated", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Graduated" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("毕业院校");
        cMap.setInheritance("false");
        cMap.setSize( 200 );
        cMap.setPosition(8);
        tMap.addColumn(cMap);
  // ------------- Column: pro --------------------
        cMap = new ColumnMap( "pro", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Pro" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("专业背景");
        cMap.setInheritance("false");
        cMap.setSize( 200 );
        cMap.setPosition(9);
        tMap.addColumn(cMap);
  // ------------- Column: address --------------------
        cMap = new ColumnMap( "address", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Address" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("住址");
        cMap.setInheritance("false");
        cMap.setSize( 200 );
        cMap.setPosition(10);
        tMap.addColumn(cMap);
  // ------------- Column: experience --------------------
        cMap = new ColumnMap( "experience", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Experience" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("教学经历");
        cMap.setInheritance("false");
        cMap.setSize( 200 );
        cMap.setPosition(11);
        tMap.addColumn(cMap);
  // ------------- Column: research --------------------
        cMap = new ColumnMap( "research", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Research" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("科研成果");
        cMap.setInheritance("false");
        cMap.setSize( 200 );
        cMap.setPosition(12);
        tMap.addColumn(cMap);
  // ------------- Column: reading_school --------------------
        cMap = new ColumnMap( "reading_school", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ReadingSchool" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("在读院校");
        cMap.setInheritance("false");
        cMap.setSize( 200 );
        cMap.setPosition(13);
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
        cMap.setPosition(14);
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
        cMap.setPosition(15);
        tMap.addColumn(cMap);
  // ------------- Column: entry_time --------------------
        cMap = new ColumnMap( "entry_time", tMap);
        cMap.setType( new Date() );
        cMap.setTorqueType( "DATE" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "EntryTime" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("入职时间");
        cMap.setInheritance("false");
        cMap.setPosition(16);
        tMap.addColumn(cMap);
  // ------------- Column: lizhi_time --------------------
        cMap = new ColumnMap( "lizhi_time", tMap);
        cMap.setType( new Date() );
        cMap.setTorqueType( "DATE" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "LizhiTime" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("离职时间");
        cMap.setInheritance("false");
        cMap.setPosition(17);
        tMap.addColumn(cMap);
  // ------------- Column: type --------------------
        cMap = new ColumnMap( "type", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Type" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("0正编，1外聘");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(18);
        tMap.addColumn(cMap);
  // ------------- Column: card_numb --------------------
        cMap = new ColumnMap( "card_numb", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "CardNumb" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("身份证号");
        cMap.setInheritance("false");
        cMap.setSize( 20 );
        cMap.setPosition(19);
        tMap.addColumn(cMap);
  // ------------- Column: head_pic --------------------
        cMap = new ColumnMap( "head_pic", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "HeadPic" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("头像");
        cMap.setInheritance("false");
        cMap.setSize( 200 );
        cMap.setPosition(20);
        tMap.addColumn(cMap);
  // ------------- Column: state --------------------
        cMap = new ColumnMap( "state", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "State" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("教师状态：0正常；1返校；2离校");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(21);
        tMap.addColumn(cMap);
  // ------------- Column: state_uptime --------------------
        cMap = new ColumnMap( "state_uptime", tMap);
        cMap.setType( new Date() );
        cMap.setTorqueType( "DATE" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "StateUptime" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("离校时间，返校时间");
        cMap.setInheritance("false");
        cMap.setPosition(22);
        tMap.addColumn(cMap);
        tMap.setUseInheritance(false);
    }
}
