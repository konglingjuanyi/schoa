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
public class QuestionMaterialsKechengMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "com.hao.schoa.po.map.QuestionMaterialsKechengMapBuilder";

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

        dbMap.addTable("question_materials_kecheng");
        TableMap tMap = dbMap.getTable("question_materials_kecheng");
        tMap.setJavaName("QuestionMaterialsKecheng");
        tMap.setOMClass( com.hao.schoa.po.QuestionMaterialsKecheng.class );
        tMap.setPeerClass( com.hao.schoa.po.QuestionMaterialsKechengPeer.class );
        tMap.setPrimaryKeyMethod(TableMap.NATIVE);
        DB dbAdapter = Torque.getDB("schoa");
        if (dbAdapter.getIDMethodType().equals(DB.SEQUENCE))
        {
            tMap.setPrimaryKeyMethodInfo("question_materials_kecheng_SEQ");
        }
        else if (dbAdapter.getIDMethodType().equals(DB.AUTO_INCREMENT))
        {
            tMap.setPrimaryKeyMethodInfo("question_materials_kecheng");
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
        cMap.setDescription("课程名");
        cMap.setInheritance("false");
        cMap.setSize( 80 );
        cMap.setPosition(2);
        tMap.addColumn(cMap);
  // ------------- Column: directions --------------------
        cMap = new ColumnMap( "directions", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Directions" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("课程说明");
        cMap.setInheritance("false");
        cMap.setSize( 200 );
        cMap.setPosition(3);
        tMap.addColumn(cMap);
  // ------------- Column: materials_id --------------------
        cMap = new ColumnMap( "materials_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "MaterialsId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("所属教材");
        cMap.setDefault("0");
        cMap.setInheritance("false");
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
  // ------------- Column: modify_time --------------------
        cMap = new ColumnMap( "modify_time", tMap);
        cMap.setType( new Date() );
        cMap.setTorqueType( "TIMESTAMP" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ModifyTime" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("修改时间");
        cMap.setInheritance("false");
        cMap.setPosition(8);
        tMap.addColumn(cMap);
  // ------------- Column: modify_member_id --------------------
        cMap = new ColumnMap( "modify_member_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ModifyMemberId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("修改人");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(9);
        tMap.addColumn(cMap);
  // ------------- Column: modify_member --------------------
        cMap = new ColumnMap( "modify_member", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ModifyMember" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("修改人");
        cMap.setInheritance("false");
        cMap.setSize( 50 );
        cMap.setPosition(10);
        tMap.addColumn(cMap);
        tMap.setUseInheritance(false);
    }
}
