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
public class PaperAnalysisMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "com.hao.schoa.po.map.PaperAnalysisMapBuilder";

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

        dbMap.addTable("paper_analysis");
        TableMap tMap = dbMap.getTable("paper_analysis");
        tMap.setJavaName("PaperAnalysis");
        tMap.setOMClass( com.hao.schoa.po.PaperAnalysis.class );
        tMap.setPeerClass( com.hao.schoa.po.PaperAnalysisPeer.class );
        tMap.setPrimaryKeyMethod(TableMap.NATIVE);
        DB dbAdapter = Torque.getDB("schoa");
        if (dbAdapter.getIDMethodType().equals(DB.SEQUENCE))
        {
            tMap.setPrimaryKeyMethodInfo("paper_analysis_SEQ");
        }
        else if (dbAdapter.getIDMethodType().equals(DB.AUTO_INCREMENT))
        {
            tMap.setPrimaryKeyMethodInfo("paper_analysis");
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
        cMap.setDescription("学期");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(2);
        tMap.addColumn(cMap);
  // ------------- Column: classes_id --------------------
        cMap = new ColumnMap( "classes_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ClassesId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("班级id");
        cMap.setDefault("0");
        cMap.setInheritance("false");
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
  // ------------- Column: mingti_teacher --------------------
        cMap = new ColumnMap( "mingti_teacher", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "MingtiTeacher" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("命题教师");
        cMap.setInheritance("false");
        cMap.setSize( 100 );
        cMap.setPosition(5);
        tMap.addColumn(cMap);
  // ------------- Column: kaoshi_type --------------------
        cMap = new ColumnMap( "kaoshi_type", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "KaoshiType" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("考试方式");
        cMap.setInheritance("false");
        cMap.setSize( 200 );
        cMap.setPosition(6);
        tMap.addColumn(cMap);
  // ------------- Column: zl_01 --------------------
        cMap = new ColumnMap( "zl_01", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Zl01" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("试题质量－命题规范，1-A,2-B,3-C,4-D");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(7);
        tMap.addColumn(cMap);
  // ------------- Column: zl_02 --------------------
        cMap = new ColumnMap( "zl_02", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Zl02" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("试题质量－ 题量，1-A,2-B,3-C,4-D");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(8);
        tMap.addColumn(cMap);
  // ------------- Column: zl_03 --------------------
        cMap = new ColumnMap( "zl_03", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Zl03" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("试题质量－ 难易，1-A,2-B,3-C,4-D");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(9);
        tMap.addColumn(cMap);
  // ------------- Column: zl_04 --------------------
        cMap = new ColumnMap( "zl_04", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Zl04" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("试题质量－ 覆盖面，1-A,2-B,3-C,4-D");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(10);
        tMap.addColumn(cMap);
  // ------------- Column: zl_05 --------------------
        cMap = new ColumnMap( "zl_05", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Zl05" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("试题质量－ 综合性，1-A,2-B,3-C,4-D");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(11);
        tMap.addColumn(cMap);
  // ------------- Column: fen_90 --------------------
        cMap = new ColumnMap( "fen_90", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Fen90" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("90分以上");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(12);
        tMap.addColumn(cMap);
  // ------------- Column: fen_90_bili --------------------
        cMap = new ColumnMap( "fen_90_bili", tMap);
        cMap.setType( new Double(0) );
        cMap.setTorqueType( "DOUBLE" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Fen90Bili" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("90分以上所占比例");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(13);
        tMap.addColumn(cMap);
  // ------------- Column: fen_8089 --------------------
        cMap = new ColumnMap( "fen_8089", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Fen8089" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("80－89");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(14);
        tMap.addColumn(cMap);
  // ------------- Column: fen_8089_bili --------------------
        cMap = new ColumnMap( "fen_8089_bili", tMap);
        cMap.setType( new Double(0) );
        cMap.setTorqueType( "DOUBLE" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Fen8089Bili" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("80－89所占比例");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(15);
        tMap.addColumn(cMap);
  // ------------- Column: fen_7079 --------------------
        cMap = new ColumnMap( "fen_7079", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Fen7079" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("70-79");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(16);
        tMap.addColumn(cMap);
  // ------------- Column: fen_7079_bili --------------------
        cMap = new ColumnMap( "fen_7079_bili", tMap);
        cMap.setType( new Double(0) );
        cMap.setTorqueType( "DOUBLE" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Fen7079Bili" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("70-79所占比例");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(17);
        tMap.addColumn(cMap);
  // ------------- Column: fen_6069 --------------------
        cMap = new ColumnMap( "fen_6069", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Fen6069" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("60-69");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(18);
        tMap.addColumn(cMap);
  // ------------- Column: fen_6069_bili --------------------
        cMap = new ColumnMap( "fen_6069_bili", tMap);
        cMap.setType( new Double(0) );
        cMap.setTorqueType( "DOUBLE" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Fen6069Bili" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("60-69所占比例");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(19);
        tMap.addColumn(cMap);
  // ------------- Column: fen_59 --------------------
        cMap = new ColumnMap( "fen_59", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Fen59" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("59分以下");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(20);
        tMap.addColumn(cMap);
  // ------------- Column: fen_59_bili --------------------
        cMap = new ColumnMap( "fen_59_bili", tMap);
        cMap.setType( new Double(0) );
        cMap.setTorqueType( "DOUBLE" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Fen59Bili" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("59分以下所占比例");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(21);
        tMap.addColumn(cMap);
  // ------------- Column: total --------------------
        cMap = new ColumnMap( "total", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Total" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("总计人数");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(22);
        tMap.addColumn(cMap);
  // ------------- Column: total_bili --------------------
        cMap = new ColumnMap( "total_bili", tMap);
        cMap.setType( new Double(0) );
        cMap.setTorqueType( "DOUBLE" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "TotalBili" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("总成绩比例");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(23);
        tMap.addColumn(cMap);
  // ------------- Column: fenxi_1 --------------------
        cMap = new ColumnMap( "fenxi_1", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Fenxi1" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("分析1");
        cMap.setInheritance("false");
        cMap.setSize( 2000 );
        cMap.setPosition(24);
        tMap.addColumn(cMap);
  // ------------- Column: fenxi_2 --------------------
        cMap = new ColumnMap( "fenxi_2", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Fenxi2" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("分析2");
        cMap.setInheritance("false");
        cMap.setSize( 2000 );
        cMap.setPosition(25);
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
        cMap.setDescription("操作人");
        cMap.setInheritance("false");
        cMap.setSize( 50 );
        cMap.setPosition(26);
        tMap.addColumn(cMap);
  // ------------- Column: update_time --------------------
        cMap = new ColumnMap( "update_time", tMap);
        cMap.setType( new Date() );
        cMap.setTorqueType( "DATE" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "UpdateTime" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("操作时间");
        cMap.setInheritance("false");
        cMap.setPosition(27);
        tMap.addColumn(cMap);
        tMap.setUseInheritance(false);
    }
}
