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
public class ScoreMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "com.hao.schoa.po.map.ScoreMapBuilder";

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

        dbMap.addTable("score");
        TableMap tMap = dbMap.getTable("score");
        tMap.setJavaName("Score");
        tMap.setOMClass( com.hao.schoa.po.Score.class );
        tMap.setPeerClass( com.hao.schoa.po.ScorePeer.class );
        tMap.setPrimaryKeyMethod(TableMap.NATIVE);
        DB dbAdapter = Torque.getDB("schoa");
        if (dbAdapter.getIDMethodType().equals(DB.SEQUENCE))
        {
            tMap.setPrimaryKeyMethodInfo("score_SEQ");
        }
        else if (dbAdapter.getIDMethodType().equals(DB.AUTO_INCREMENT))
        {
            tMap.setPrimaryKeyMethodInfo("score");
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
  // ------------- Column: class_id --------------------
        cMap = new ColumnMap( "class_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ClassId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("班级id");
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
  // ------------- Column: student_id --------------------
        cMap = new ColumnMap( "student_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "StudentId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("学生id");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(4);
        tMap.addColumn(cMap);
  // ------------- Column: sc_keguan --------------------
        cMap = new ColumnMap( "sc_keguan", tMap);
        cMap.setType( new Double(0) );
        cMap.setTorqueType( "DOUBLE" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ScKeguan" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("客观成绩");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(5);
        tMap.addColumn(cMap);
  // ------------- Column: sc_zhuguan --------------------
        cMap = new ColumnMap( "sc_zhuguan", tMap);
        cMap.setType( new Double(0) );
        cMap.setTorqueType( "DOUBLE" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ScZhuguan" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("主管成绩");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(6);
        tMap.addColumn(cMap);
  // ------------- Column: sc_juanmian --------------------
        cMap = new ColumnMap( "sc_juanmian", tMap);
        cMap.setType( new Double(0) );
        cMap.setTorqueType( "DOUBLE" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ScJuanmian" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("卷面成绩");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(7);
        tMap.addColumn(cMap);
  // ------------- Column: sc_qizhong --------------------
        cMap = new ColumnMap( "sc_qizhong", tMap);
        cMap.setType( new Double(0) );
        cMap.setTorqueType( "DOUBLE" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ScQizhong" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("其中成绩");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(8);
        tMap.addColumn(cMap);
  // ------------- Column: sc_zuoye --------------------
        cMap = new ColumnMap( "sc_zuoye", tMap);
        cMap.setType( new Double(0) );
        cMap.setTorqueType( "DOUBLE" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ScZuoye" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("作业成绩");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(9);
        tMap.addColumn(cMap);
  // ------------- Column: sc_chuqin --------------------
        cMap = new ColumnMap( "sc_chuqin", tMap);
        cMap.setType( new Double(0) );
        cMap.setTorqueType( "DOUBLE" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ScChuqin" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("出勤成绩");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(10);
        tMap.addColumn(cMap);
  // ------------- Column: sc_all --------------------
        cMap = new ColumnMap( "sc_all", tMap);
        cMap.setType( new Double(0) );
        cMap.setTorqueType( "DOUBLE" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ScAll" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("总成绩");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(11);
        tMap.addColumn(cMap);
  // ------------- Column: sc_40 --------------------
        cMap = new ColumnMap( "sc_40", tMap);
        cMap.setType( new Double(0) );
        cMap.setTorqueType( "DOUBLE" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Sc40" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("40%成绩");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(12);
        tMap.addColumn(cMap);
  // ------------- Column: sc_20 --------------------
        cMap = new ColumnMap( "sc_20", tMap);
        cMap.setType( new Double(0) );
        cMap.setTorqueType( "DOUBLE" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Sc20" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("20%成绩");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(13);
        tMap.addColumn(cMap);
  // ------------- Column: remark --------------------
        cMap = new ColumnMap( "remark", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Remark" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("备注");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setSize( 200 );
        cMap.setPosition(14);
        tMap.addColumn(cMap);
        tMap.setUseInheritance(false);
    }
}
