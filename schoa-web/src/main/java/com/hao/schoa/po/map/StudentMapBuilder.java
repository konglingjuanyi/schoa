package com.hao.schoa.po.map;

import java.util.Date;
import java.math.BigDecimal;

import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.adapter.DB;
import org.apache.torque.map.MapBuilder;
import org.apache.torque.map.DatabaseMap;
import org.apache.torque.map.TableMap;
import org.apache.torque.map.ColumnMap;
import org.apache.torque.map.InheritanceMap;

/**
  */
public class StudentMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "com.hao.schoa.po.map.StudentMapBuilder";

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

        dbMap.addTable("student");
        TableMap tMap = dbMap.getTable("student");
        tMap.setJavaName("Student");
        tMap.setOMClass( com.hao.schoa.po.Student.class );
        tMap.setPeerClass( com.hao.schoa.po.StudentPeer.class );
        tMap.setPrimaryKeyMethod(TableMap.NATIVE);
        DB dbAdapter = Torque.getDB("schoa");
        if (dbAdapter.getIDMethodType().equals(DB.SEQUENCE))
        {
            tMap.setPrimaryKeyMethodInfo("student_SEQ");
        }
        else if (dbAdapter.getIDMethodType().equals(DB.AUTO_INCREMENT))
        {
            tMap.setPrimaryKeyMethodInfo("student");
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
        cMap.setDescription("学生证号");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(2);
        tMap.addColumn(cMap);
  // ------------- Column: ename --------------------
        cMap = new ColumnMap( "ename", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Ename" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("英文名字");
        cMap.setInheritance("false");
        cMap.setSize( 50 );
        cMap.setPosition(3);
        tMap.addColumn(cMap);
  // ------------- Column: cname --------------------
        cMap = new ColumnMap( "cname", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Cname" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("中文名");
        cMap.setInheritance("false");
        cMap.setSize( 50 );
        cMap.setPosition(4);
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
        cMap.setPosition(5);
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
        cMap.setPosition(6);
        tMap.addColumn(cMap);
  // ------------- Column: pass_numb --------------------
        cMap = new ColumnMap( "pass_numb", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "PassNumb" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("护照号");
        cMap.setInheritance("false");
        cMap.setSize( 50 );
        cMap.setPosition(7);
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
        cMap.setSize( 50 );
        cMap.setPosition(8);
        tMap.addColumn(cMap);
  // ------------- Column: nation --------------------
        cMap = new ColumnMap( "nation", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Nation" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("国家");
        cMap.setDefault("0");
        cMap.setInheritance("false");
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
  // ------------- Column: closed_date --------------------
        cMap = new ColumnMap( "closed_date", tMap);
        cMap.setType( new Date() );
        cMap.setTorqueType( "DATE" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ClosedDate" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("结业日期");
        cMap.setInheritance("false");
        cMap.setPosition(11);
        tMap.addColumn(cMap);
  // ------------- Column: cost_from --------------------
        cMap = new ColumnMap( "cost_from", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "CostFrom" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("资金费用来源");
        cMap.setInheritance("false");
        cMap.setPosition(12);
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
        cMap.setPosition(13);
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
        cMap.setPosition(14);
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
        cMap.setDescription("学生状态：0正常；1返校；2离校");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(15);
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
        cMap.setPosition(16);
        tMap.addColumn(cMap);
  // ------------- Column: state_intro --------------------
        cMap = new ColumnMap( "state_intro", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "StateIntro" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("离校原因，返校原因");
        cMap.setInheritance("false");
        cMap.setSize( 300 );
        cMap.setPosition(17);
        tMap.addColumn(cMap);
  // ------------- Column: stu_from --------------------
        cMap = new ColumnMap( "stu_from", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "StuFrom" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(18);
        tMap.addColumn(cMap);
        tMap.setUseInheritance(false);
    }
}
