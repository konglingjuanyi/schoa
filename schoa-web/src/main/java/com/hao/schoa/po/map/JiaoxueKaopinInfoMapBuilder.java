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
public class JiaoxueKaopinInfoMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "com.hao.schoa.po.map.JiaoxueKaopinInfoMapBuilder";

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

        dbMap.addTable("jiaoxue_kaopin_info");
        TableMap tMap = dbMap.getTable("jiaoxue_kaopin_info");
        tMap.setJavaName("JiaoxueKaopinInfo");
        tMap.setOMClass( com.hao.schoa.po.JiaoxueKaopinInfo.class );
        tMap.setPeerClass( com.hao.schoa.po.JiaoxueKaopinInfoPeer.class );
        tMap.setPrimaryKeyMethod(TableMap.NATIVE);
        DB dbAdapter = Torque.getDB("schoa");
        if (dbAdapter.getIDMethodType().equals(DB.SEQUENCE))
        {
            tMap.setPrimaryKeyMethodInfo("jiaoxue_kaopin_info_SEQ");
        }
        else if (dbAdapter.getIDMethodType().equals(DB.AUTO_INCREMENT))
        {
            tMap.setPrimaryKeyMethodInfo("jiaoxue_kaopin_info");
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
  // ------------- Column: kaopin_id --------------------
        cMap = new ColumnMap( "kaopin_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "KaopinId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("考评id");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(2);
        tMap.addColumn(cMap);
  // ------------- Column: sum_score --------------------
        cMap = new ColumnMap( "sum_score", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "SumScore" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("总分数");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(3);
        tMap.addColumn(cMap);
  // ------------- Column: anshi --------------------
        cMap = new ColumnMap( "anshi", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Anshi" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("1.按时上下课吗");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(4);
        tMap.addColumn(cMap);
  // ------------- Column: youyiyi --------------------
        cMap = new ColumnMap( "youyiyi", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Youyiyi" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("2.有意义吗");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(5);
        tMap.addColumn(cMap);
  // ------------- Column: neirong --------------------
        cMap = new ColumnMap( "neirong", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Neirong" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("3.内容懂吗");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(6);
        tMap.addColumn(cMap);
  // ------------- Column: shouhuo --------------------
        cMap = new ColumnMap( "shouhuo", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Shouhuo" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("4.有收获吗");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(7);
        tMap.addColumn(cMap);
  // ------------- Column: shuohua_qingchu --------------------
        cMap = new ColumnMap( "shuohua_qingchu", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ShuohuaQingchu" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("5.说话清楚吗");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(8);
        tMap.addColumn(cMap);
  // ------------- Column: heibanzi_qingchu --------------------
        cMap = new ColumnMap( "heibanzi_qingchu", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "HeibanziQingchu" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("6.黑板字清楚吗");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(9);
        tMap.addColumn(cMap);
  // ------------- Column: heibanzi_zhongyao --------------------
        cMap = new ColumnMap( "heibanzi_zhongyao", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "HeibanziZhongyao" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("7.黑板字内容重要吗");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(10);
        tMap.addColumn(cMap);
  // ------------- Column: shuliang_heshi --------------------
        cMap = new ColumnMap( "shuliang_heshi", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ShuliangHeshi" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("8.数量合适吗");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(11);
        tMap.addColumn(cMap);
  // ------------- Column: hanzi_jihui --------------------
        cMap = new ColumnMap( "hanzi_jihui", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "HanziJihui" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("9.汉字机会多吗");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(12);
        tMap.addColumn(cMap);
  // ------------- Column: huodong_youxiao --------------------
        cMap = new ColumnMap( "huodong_youxiao", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "HuodongYouxiao" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("10.活动有效吗");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(13);
        tMap.addColumn(cMap);
  // ------------- Column: zuoye_heshi --------------------
        cMap = new ColumnMap( "zuoye_heshi", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ZuoyeHeshi" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("11.作业合适吗");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(14);
        tMap.addColumn(cMap);
  // ------------- Column: zuoye_bangzhu --------------------
        cMap = new ColumnMap( "zuoye_bangzhu", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ZuoyeBangzhu" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("12.作业又帮助吗");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(15);
        tMap.addColumn(cMap);
  // ------------- Column: naixin --------------------
        cMap = new ColumnMap( "naixin", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Naixin" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("13.老师耐心吗");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(16);
        tMap.addColumn(cMap);
  // ------------- Column: jinbu --------------------
        cMap = new ColumnMap( "jinbu", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Jinbu" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("14.进步大吗");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(17);
        tMap.addColumn(cMap);
  // ------------- Column: yange --------------------
        cMap = new ColumnMap( "yange", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Yange" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("15.严格吗");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(18);
        tMap.addColumn(cMap);
  // ------------- Column: yuanyi --------------------
        cMap = new ColumnMap( "yuanyi", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Yuanyi" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("16.愿意吗");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(19);
        tMap.addColumn(cMap);
  // ------------- Column: liaotian --------------------
        cMap = new ColumnMap( "liaotian", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Liaotian" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("17.聊天吗");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(20);
        tMap.addColumn(cMap);
  // ------------- Column: pingjia --------------------
        cMap = new ColumnMap( "pingjia", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "LONGVARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Pingjia" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("对老师的评价");
        cMap.setInheritance("false");
        cMap.setSize( 65535 );
        cMap.setPosition(21);
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
        cMap.setPosition(22);
        tMap.addColumn(cMap);
  // ------------- Column: man_id --------------------
        cMap = new ColumnMap( "man_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ManId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("操作人");
        cMap.setInheritance("false");
        cMap.setPosition(23);
        tMap.addColumn(cMap);
  // ------------- Column: man_name --------------------
        cMap = new ColumnMap( "man_name", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ManName" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("操作人");
        cMap.setInheritance("false");
        cMap.setSize( 50 );
        cMap.setPosition(24);
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
        cMap.setPosition(25);
        tMap.addColumn(cMap);
        tMap.setUseInheritance(false);
    }
}
