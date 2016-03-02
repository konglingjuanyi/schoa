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
public class JixiaoZaibianMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "com.hao.schoa.po.map.JixiaoZaibianMapBuilder";

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

        dbMap.addTable("jixiao_zaibian");
        TableMap tMap = dbMap.getTable("jixiao_zaibian");
        tMap.setJavaName("JixiaoZaibian");
        tMap.setOMClass( com.hao.schoa.po.JixiaoZaibian.class );
        tMap.setPeerClass( com.hao.schoa.po.JixiaoZaibianPeer.class );
        tMap.setPrimaryKeyMethod(TableMap.NATIVE);
        DB dbAdapter = Torque.getDB("schoa");
        if (dbAdapter.getIDMethodType().equals(DB.SEQUENCE))
        {
            tMap.setPrimaryKeyMethodInfo("jixiao_zaibian_SEQ");
        }
        else if (dbAdapter.getIDMethodType().equals(DB.AUTO_INCREMENT))
        {
            tMap.setPrimaryKeyMethodInfo("jixiao_zaibian");
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
        cMap.setPosition(5);
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
        cMap.setDescription("开会出勤");
        cMap.setInheritance("false");
        cMap.setSize( 200 );
        cMap.setPosition(6);
        tMap.addColumn(cMap);
  // ------------- Column: sc_banzhuren --------------------
        cMap = new ColumnMap( "sc_banzhuren", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ScBanzhuren" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("班主任工作");
        cMap.setInheritance("false");
        cMap.setSize( 200 );
        cMap.setPosition(7);
        tMap.addColumn(cMap);
  // ------------- Column: sc_jianren --------------------
        cMap = new ColumnMap( "sc_jianren", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ScJianren" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("兼任工作");
        cMap.setInheritance("false");
        cMap.setSize( 200 );
        cMap.setPosition(8);
        tMap.addColumn(cMap);
  // ------------- Column: sc_other --------------------
        cMap = new ColumnMap( "sc_other", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ScOther" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("其他工作");
        cMap.setInheritance("false");
        cMap.setSize( 200 );
        cMap.setPosition(9);
        tMap.addColumn(cMap);
  // ------------- Column: sc_jiang --------------------
        cMap = new ColumnMap( "sc_jiang", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ScJiang" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("得奖情况");
        cMap.setInheritance("false");
        cMap.setSize( 200 );
        cMap.setPosition(10);
        tMap.addColumn(cMap);
  // ------------- Column: sc_gongzuoliang --------------------
        cMap = new ColumnMap( "sc_gongzuoliang", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ScGongzuoliang" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("教学工作量");
        cMap.setInheritance("false");
        cMap.setSize( 200 );
        cMap.setPosition(11);
        tMap.addColumn(cMap);
  // ------------- Column: sc_kaohe_file --------------------
        cMap = new ColumnMap( "sc_kaohe_file", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ScKaoheFile" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("教学考核文件保存路径");
        cMap.setInheritance("false");
        cMap.setSize( 200 );
        cMap.setPosition(12);
        tMap.addColumn(cMap);
  // ------------- Column: sc_kaohe_filename --------------------
        cMap = new ColumnMap( "sc_kaohe_filename", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ScKaoheFilename" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("教学考核文件名");
        cMap.setInheritance("false");
        cMap.setSize( 200 );
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
        cMap.setInheritance("false");
        cMap.setSize( 500 );
        cMap.setPosition(14);
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
        cMap.setPosition(15);
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
        cMap.setPosition(16);
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
        cMap.setPosition(17);
        tMap.addColumn(cMap);
        tMap.setUseInheritance(false);
    }
}
