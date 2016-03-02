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
public class QuestionPaperMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "com.hao.schoa.po.map.QuestionPaperMapBuilder";

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

        dbMap.addTable("question_paper");
        TableMap tMap = dbMap.getTable("question_paper");
        tMap.setJavaName("QuestionPaper");
        tMap.setOMClass( com.hao.schoa.po.QuestionPaper.class );
        tMap.setPeerClass( com.hao.schoa.po.QuestionPaperPeer.class );
        tMap.setPrimaryKeyMethod(TableMap.NATIVE);
        DB dbAdapter = Torque.getDB("schoa");
        if (dbAdapter.getIDMethodType().equals(DB.SEQUENCE))
        {
            tMap.setPrimaryKeyMethodInfo("question_paper_SEQ");
        }
        else if (dbAdapter.getIDMethodType().equals(DB.AUTO_INCREMENT))
        {
            tMap.setPrimaryKeyMethodInfo("question_paper");
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
  // ------------- Column: title --------------------
        cMap = new ColumnMap( "title", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Title" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("试卷名称");
        cMap.setInheritance("false");
        cMap.setSize( 200 );
        cMap.setPosition(2);
        tMap.addColumn(cMap);
  // ------------- Column: member --------------------
        cMap = new ColumnMap( "member", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Member" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("创建人");
        cMap.setInheritance("false");
        cMap.setSize( 50 );
        cMap.setPosition(3);
        tMap.addColumn(cMap);
  // ------------- Column: questions --------------------
        cMap = new ColumnMap( "questions", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Questions" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("试题（1,2,3,4）");
        cMap.setInheritance("false");
        cMap.setSize( 500 );
        cMap.setPosition(4);
        tMap.addColumn(cMap);
  // ------------- Column: create_time --------------------
        cMap = new ColumnMap( "create_time", tMap);
        cMap.setType( new Date() );
        cMap.setTorqueType( "TIMESTAMP" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "CreateTime" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("创建时间");
        cMap.setInheritance("false");
        cMap.setPosition(5);
        tMap.addColumn(cMap);
  // ------------- Column: create_member_id --------------------
        cMap = new ColumnMap( "create_member_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "CreateMemberId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("创建人");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(6);
        tMap.addColumn(cMap);
  // ------------- Column: create_member --------------------
        cMap = new ColumnMap( "create_member", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "CreateMember" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("创建人");
        cMap.setInheritance("false");
        cMap.setSize( 50 );
        cMap.setPosition(7);
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
        cMap.setDescription("是否有效；1有效，0无效");
        cMap.setDefault("1");
        cMap.setInheritance("false");
        cMap.setPosition(8);
        tMap.addColumn(cMap);
  // ------------- Column: del_time --------------------
        cMap = new ColumnMap( "del_time", tMap);
        cMap.setType( new Date() );
        cMap.setTorqueType( "TIMESTAMP" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "DelTime" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("删除时间");
        cMap.setInheritance("false");
        cMap.setPosition(9);
        tMap.addColumn(cMap);
  // ------------- Column: del_member_id --------------------
        cMap = new ColumnMap( "del_member_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "DelMemberId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("删除人");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(10);
        tMap.addColumn(cMap);
  // ------------- Column: del_member --------------------
        cMap = new ColumnMap( "del_member", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "DelMember" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("删除人");
        cMap.setInheritance("false");
        cMap.setSize( 50 );
        cMap.setPosition(11);
        tMap.addColumn(cMap);
        tMap.setUseInheritance(false);
    }
}
