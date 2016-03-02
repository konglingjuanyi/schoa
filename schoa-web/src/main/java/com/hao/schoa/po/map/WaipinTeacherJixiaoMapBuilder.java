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
public class WaipinTeacherJixiaoMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "com.hao.schoa.po.map.WaipinTeacherJixiaoMapBuilder";

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

        dbMap.addTable("waipin_teacher_jixiao");
        TableMap tMap = dbMap.getTable("waipin_teacher_jixiao");
        tMap.setJavaName("WaipinTeacherJixiao");
        tMap.setOMClass( com.hao.schoa.po.WaipinTeacherJixiao.class );
        tMap.setPeerClass( com.hao.schoa.po.WaipinTeacherJixiaoPeer.class );
        tMap.setPrimaryKeyMethod(TableMap.NATIVE);
        DB dbAdapter = Torque.getDB("schoa");
        if (dbAdapter.getIDMethodType().equals(DB.SEQUENCE))
        {
            tMap.setPrimaryKeyMethodInfo("waipin_teacher_jixiao_SEQ");
        }
        else if (dbAdapter.getIDMethodType().equals(DB.AUTO_INCREMENT))
        {
            tMap.setPrimaryKeyMethodInfo("waipin_teacher_jixiao");
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
  // ------------- Column: youxiu --------------------
        cMap = new ColumnMap( "youxiu", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Youxiu" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("1优秀；0一般");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(2);
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
        cMap.setPosition(3);
        tMap.addColumn(cMap);
  // ------------- Column: banji_id --------------------
        cMap = new ColumnMap( "banji_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "BanjiId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("班级id");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(4);
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
        cMap.setPosition(5);
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
        cMap.setPosition(6);
        tMap.addColumn(cMap);
  // ------------- Column: teacher_name --------------------
        cMap = new ColumnMap( "teacher_name", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "TeacherName" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("教师名称");
        cMap.setInheritance("false");
        cMap.setSize( 20 );
        cMap.setPosition(7);
        tMap.addColumn(cMap);
  // ------------- Column: sc_kaopin --------------------
        cMap = new ColumnMap( "sc_kaopin", tMap);
        cMap.setType( new Double(0) );
        cMap.setTorqueType( "DOUBLE" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ScKaopin" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("教学考评得分");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(8);
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
        cMap.setDescription("上课出勤得分");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(9);
        tMap.addColumn(cMap);
  // ------------- Column: sc_jiaoxuefile --------------------
        cMap = new ColumnMap( "sc_jiaoxuefile", tMap);
        cMap.setType( new Double(0) );
        cMap.setTorqueType( "DOUBLE" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ScJiaoxuefile" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("教学文件得分");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(10);
        tMap.addColumn(cMap);
  // ------------- Column: sc_tingke --------------------
        cMap = new ColumnMap( "sc_tingke", tMap);
        cMap.setType( new Double(0) );
        cMap.setTorqueType( "DOUBLE" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ScTingke" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("听课情况得分");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(11);
        tMap.addColumn(cMap);
  // ------------- Column: sc_kaihui --------------------
        cMap = new ColumnMap( "sc_kaihui", tMap);
        cMap.setType( new Double(0) );
        cMap.setTorqueType( "DOUBLE" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ScKaihui" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("开会出勤得分");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(12);
        tMap.addColumn(cMap);
  // ------------- Column: sc_kaihui_reason --------------------
        cMap = new ColumnMap( "sc_kaihui_reason", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ScKaihuiReason" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("开会出勤得分原因");
        cMap.setInheritance("false");
        cMap.setSize( 200 );
        cMap.setPosition(13);
        tMap.addColumn(cMap);
  // ------------- Column: sc_huodong --------------------
        cMap = new ColumnMap( "sc_huodong", tMap);
        cMap.setType( new Double(0) );
        cMap.setTorqueType( "DOUBLE" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ScHuodong" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("参加学生活动得分");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(14);
        tMap.addColumn(cMap);
  // ------------- Column: sc_huodong_reason --------------------
        cMap = new ColumnMap( "sc_huodong_reason", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ScHuodongReason" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("参加学生活动得分原因");
        cMap.setInheritance("false");
        cMap.setSize( 200 );
        cMap.setPosition(15);
        tMap.addColumn(cMap);
  // ------------- Column: sc_yinxiang --------------------
        cMap = new ColumnMap( "sc_yinxiang", tMap);
        cMap.setType( new Double(0) );
        cMap.setTorqueType( "DOUBLE" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ScYinxiang" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("印象得分");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(16);
        tMap.addColumn(cMap);
  // ------------- Column: sc_yinxiang_reason --------------------
        cMap = new ColumnMap( "sc_yinxiang_reason", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ScYinxiangReason" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("印象得分原因");
        cMap.setInheritance("false");
        cMap.setSize( 200 );
        cMap.setPosition(17);
        tMap.addColumn(cMap);
  // ------------- Column: sc_gongxian --------------------
        cMap = new ColumnMap( "sc_gongxian", tMap);
        cMap.setType( new Double(0) );
        cMap.setTorqueType( "DOUBLE" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ScGongxian" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("特殊贡献得分");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(18);
        tMap.addColumn(cMap);
  // ------------- Column: sc_gongxian_reason --------------------
        cMap = new ColumnMap( "sc_gongxian_reason", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ScGongxianReason" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("特殊贡献得分原因");
        cMap.setInheritance("false");
        cMap.setSize( 200 );
        cMap.setPosition(19);
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
        cMap.setInheritance("false");
        cMap.setSize( 500 );
        cMap.setPosition(20);
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
        cMap.setDescription("操作人");
        cMap.setInheritance("false");
        cMap.setPosition(21);
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
        cMap.setDescription("操作人");
        cMap.setInheritance("false");
        cMap.setSize( 50 );
        cMap.setPosition(22);
        tMap.addColumn(cMap);
  // ------------- Column: update_time --------------------
        cMap = new ColumnMap( "update_time", tMap);
        cMap.setType( new Date() );
        cMap.setTorqueType( "TIMESTAMP" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "UpdateTime" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("更新时间");
        cMap.setInheritance("false");
        cMap.setPosition(23);
        tMap.addColumn(cMap);
        tMap.setUseInheritance(false);
    }
}
