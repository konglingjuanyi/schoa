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
public class QuestionBankMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "com.hao.schoa.po.map.QuestionBankMapBuilder";

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

        dbMap.addTable("question_bank");
        TableMap tMap = dbMap.getTable("question_bank");
        tMap.setJavaName("QuestionBank");
        tMap.setOMClass( com.hao.schoa.po.QuestionBank.class );
        tMap.setPeerClass( com.hao.schoa.po.QuestionBankPeer.class );
        tMap.setPrimaryKeyMethod(TableMap.NATIVE);
        DB dbAdapter = Torque.getDB("schoa");
        if (dbAdapter.getIDMethodType().equals(DB.SEQUENCE))
        {
            tMap.setPrimaryKeyMethodInfo("question_bank_SEQ");
        }
        else if (dbAdapter.getIDMethodType().equals(DB.AUTO_INCREMENT))
        {
            tMap.setPrimaryKeyMethodInfo("question_bank");
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
  // ------------- Column: content --------------------
        cMap = new ColumnMap( "content", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "LONGVARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Content" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("试题内容");
        cMap.setInheritance("false");
        cMap.setSize( 65535 );
        cMap.setPosition(2);
        tMap.addColumn(cMap);
  // ------------- Column: answer --------------------
        cMap = new ColumnMap( "answer", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "LONGVARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Answer" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("试题答案");
        cMap.setInheritance("false");
        cMap.setSize( 65535 );
        cMap.setPosition(3);
        tMap.addColumn(cMap);
  // ------------- Column: img --------------------
        cMap = new ColumnMap( "img", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Img" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("图片");
        cMap.setInheritance("false");
        cMap.setSize( 50 );
        cMap.setPosition(4);
        tMap.addColumn(cMap);
  // ------------- Column: tixing_id --------------------
        cMap = new ColumnMap( "tixing_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "TixingId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("题型");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(5);
        tMap.addColumn(cMap);
  // ------------- Column: material_id --------------------
        cMap = new ColumnMap( "material_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "MaterialId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("教材");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(6);
        tMap.addColumn(cMap);
  // ------------- Column: material_kecheng_id --------------------
        cMap = new ColumnMap( "material_kecheng_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "MaterialKechengId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("教材课程");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(7);
        tMap.addColumn(cMap);
  // ------------- Column: knowledge_point_id --------------------
        cMap = new ColumnMap( "knowledge_point_id", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "KnowledgePointId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("");
        cMap.setInheritance("false");
        cMap.setSize( 100 );
        cMap.setPosition(8);
        tMap.addColumn(cMap);
  // ------------- Column: words_level --------------------
        cMap = new ColumnMap( "words_level", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "WordsLevel" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("词汇标准及级别，标准ID*10000+级别ID*1");
        cMap.setInheritance("false");
        cMap.setSize( 100 );
        cMap.setPosition(9);
        tMap.addColumn(cMap);
  // ------------- Column: tags --------------------
        cMap = new ColumnMap( "tags", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "LONGVARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Tags" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("标签");
        cMap.setInheritance("false");
        cMap.setSize( 65535 );
        cMap.setPosition(10);
        tMap.addColumn(cMap);
  // ------------- Column: fenci --------------------
        cMap = new ColumnMap( "fenci", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "LONGVARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Fenci" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("分词");
        cMap.setInheritance("false");
        cMap.setSize( 65535 );
        cMap.setPosition(11);
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
        cMap.setSize( 100 );
        cMap.setPosition(12);
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
        cMap.setPosition(13);
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
        cMap.setPosition(14);
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
        cMap.setPosition(15);
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
        cMap.setPosition(16);
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
        cMap.setPosition(17);
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
        cMap.setPosition(18);
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
        cMap.setPosition(19);
        tMap.addColumn(cMap);
  // ------------- Column: img_a --------------------
        cMap = new ColumnMap( "img_a", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ImgA" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("图片A");
        cMap.setInheritance("false");
        cMap.setSize( 50 );
        cMap.setPosition(20);
        tMap.addColumn(cMap);
  // ------------- Column: img_b --------------------
        cMap = new ColumnMap( "img_b", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ImgB" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("图片b");
        cMap.setInheritance("false");
        cMap.setSize( 50 );
        cMap.setPosition(21);
        tMap.addColumn(cMap);
  // ------------- Column: img_c --------------------
        cMap = new ColumnMap( "img_c", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ImgC" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("图片c");
        cMap.setInheritance("false");
        cMap.setSize( 50 );
        cMap.setPosition(22);
        tMap.addColumn(cMap);
  // ------------- Column: img_d --------------------
        cMap = new ColumnMap( "img_d", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ImgD" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("图片d");
        cMap.setInheritance("false");
        cMap.setSize( 50 );
        cMap.setPosition(23);
        tMap.addColumn(cMap);
  // ------------- Column: img_e --------------------
        cMap = new ColumnMap( "img_e", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ImgE" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("图片e");
        cMap.setInheritance("false");
        cMap.setSize( 50 );
        cMap.setPosition(24);
        tMap.addColumn(cMap);
  // ------------- Column: img_f --------------------
        cMap = new ColumnMap( "img_f", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "ImgF" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("图片f");
        cMap.setInheritance("false");
        cMap.setSize( 50 );
        cMap.setPosition(25);
        tMap.addColumn(cMap);
  // ------------- Column: used_times --------------------
        cMap = new ColumnMap( "used_times", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "UsedTimes" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("试题生成试卷次数");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(26);
        tMap.addColumn(cMap);
        tMap.setUseInheritance(false);
    }
}
