package com.hao.schoa.po;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.torque.NoRowsException;
import org.apache.torque.TooManyRowsException;
import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.TorqueRuntimeException;
import org.apache.torque.map.MapBuilder;
import org.apache.torque.map.TableMap;
import org.apache.torque.om.DateKey;
import org.apache.torque.om.NumberKey;
import org.apache.torque.om.StringKey;
import org.apache.torque.om.ObjectKey;
import org.apache.torque.om.SimpleKey;
import org.apache.torque.util.BasePeer;
import org.apache.torque.util.Criteria;

import com.workingdogs.village.DataSetException;
import com.workingdogs.village.QueryDataSet;
import com.workingdogs.village.Record;

// Local classes
import com.hao.schoa.po.map.*;




/**
 */
public abstract class BaseQuestionBankPeer
    extends BasePeer
{

    /** the default database name for this class */
    public static final String DATABASE_NAME;

     /** the table name for this class */
    public static final String TABLE_NAME;

    /**
     * @return the map builder for this peer
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @deprecated Torque.getMapBuilder(QuestionBankMapBuilder.CLASS_NAME) instead
     */
    public static MapBuilder getMapBuilder()
        throws TorqueException
    {
        return Torque.getMapBuilder(QuestionBankMapBuilder.CLASS_NAME);
    }

    /** the column name for the id field */
    public static final String ID;
    /** the column name for the content field */
    public static final String CONTENT;
    /** the column name for the answer field */
    public static final String ANSWER;
    /** the column name for the img field */
    public static final String IMG;
    /** the column name for the tixing_id field */
    public static final String TIXING_ID;
    /** the column name for the material_id field */
    public static final String MATERIAL_ID;
    /** the column name for the material_kecheng_id field */
    public static final String MATERIAL_KECHENG_ID;
    /** the column name for the knowledge_point_id field */
    public static final String KNOWLEDGE_POINT_ID;
    /** the column name for the words_level field */
    public static final String WORDS_LEVEL;
    /** the column name for the tags field */
    public static final String TAGS;
    /** the column name for the fenci field */
    public static final String FENCI;
    /** the column name for the remark field */
    public static final String REMARK;
    /** the column name for the member field */
    public static final String MEMBER;
    /** the column name for the create_time field */
    public static final String CREATE_TIME;
    /** the column name for the create_member_id field */
    public static final String CREATE_MEMBER_ID;
    /** the column name for the create_member field */
    public static final String CREATE_MEMBER;
    /** the column name for the modify_time field */
    public static final String MODIFY_TIME;
    /** the column name for the modify_member_id field */
    public static final String MODIFY_MEMBER_ID;
    /** the column name for the modify_member field */
    public static final String MODIFY_MEMBER;
    /** the column name for the img_a field */
    public static final String IMG_A;
    /** the column name for the img_b field */
    public static final String IMG_B;
    /** the column name for the img_c field */
    public static final String IMG_C;
    /** the column name for the img_d field */
    public static final String IMG_D;
    /** the column name for the img_e field */
    public static final String IMG_E;
    /** the column name for the img_f field */
    public static final String IMG_F;
    /** the column name for the used_times field */
    public static final String USED_TIMES;

    static
    {
        DATABASE_NAME = "schoa";
        TABLE_NAME = "question_bank";

        ID = "question_bank.id";
        CONTENT = "question_bank.content";
        ANSWER = "question_bank.answer";
        IMG = "question_bank.img";
        TIXING_ID = "question_bank.tixing_id";
        MATERIAL_ID = "question_bank.material_id";
        MATERIAL_KECHENG_ID = "question_bank.material_kecheng_id";
        KNOWLEDGE_POINT_ID = "question_bank.knowledge_point_id";
        WORDS_LEVEL = "question_bank.words_level";
        TAGS = "question_bank.tags";
        FENCI = "question_bank.fenci";
        REMARK = "question_bank.remark";
        MEMBER = "question_bank.member";
        CREATE_TIME = "question_bank.create_time";
        CREATE_MEMBER_ID = "question_bank.create_member_id";
        CREATE_MEMBER = "question_bank.create_member";
        MODIFY_TIME = "question_bank.modify_time";
        MODIFY_MEMBER_ID = "question_bank.modify_member_id";
        MODIFY_MEMBER = "question_bank.modify_member";
        IMG_A = "question_bank.img_a";
        IMG_B = "question_bank.img_b";
        IMG_C = "question_bank.img_c";
        IMG_D = "question_bank.img_d";
        IMG_E = "question_bank.img_e";
        IMG_F = "question_bank.img_f";
        USED_TIMES = "question_bank.used_times";
        if (Torque.isInit())
        {
            try
            {
                Torque.getMapBuilder(QuestionBankMapBuilder.CLASS_NAME);
            }
            catch (TorqueException e)
            {
                log.error("Could not initialize Peer", e);
                throw new TorqueRuntimeException(e);
            }
        }
        else
        {
            Torque.registerMapBuilder(QuestionBankMapBuilder.CLASS_NAME);
        }
    }
 
    /** number of columns for this peer */
    public static final int numColumns =  26;

    /** A class that can be returned by this peer. */
    protected static final String CLASSNAME_DEFAULT =
        "com.hao.schoa.po.QuestionBank";

    /** A class that can be returned by this peer. */
    protected static final Class CLASS_DEFAULT = initClass(CLASSNAME_DEFAULT);

    /**
     * Class object initialization method.
     *
     * @param className name of the class to initialize
     * @return the initialized class
     */
    private static Class initClass(String className)
    {
        Class c = null;
        try
        {
            c = Class.forName(className);
        }
        catch (Throwable t)
        {
            log.error("A FATAL ERROR has occurred which should not "
                + "have happened under any circumstance.  Please notify "
                + "the Torque developers <torque-dev@db.apache.org> "
                + "and give as many details as possible (including the error "
                + "stack trace).", t);

            // Error objects should always be propagated.
            if (t instanceof Error)
            {
                throw (Error) t.fillInStackTrace();
            }
        }
        return c;
    }

    /**
     * Get the list of objects for a ResultSet.  Please not that your
     * resultset MUST return columns in the right order.  You can use
     * getFieldNames() in BaseObject to get the correct sequence.
     *
     * @param results the ResultSet
     * @return the list of objects
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List resultSet2Objects(java.sql.ResultSet results)
            throws TorqueException
    {
        try
        {
            QueryDataSet qds = null;
            List rows = null;
            try
            {
                qds = new QueryDataSet(results);
                rows = getSelectResults(qds);
            }
            finally
            {
                if (qds != null)
                {
                    qds.close();
                }
            }

            return populateObjects(rows);
        }
        catch (SQLException e)
        {
            throw new TorqueException(e);
        }
        catch (DataSetException e)
        {
            throw new TorqueException(e);
        }
    }



    /**
     * Method to do inserts.
     *
     * @param criteria object used to create the INSERT statement.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static ObjectKey doInsert(Criteria criteria)
        throws TorqueException
    {
        return BaseQuestionBankPeer
            .doInsert(criteria, (Connection) null);
    }

    /**
     * Method to do inserts.  This method is to be used during a transaction,
     * otherwise use the doInsert(Criteria) method.  It will take care of
     * the connection details internally.
     *
     * @param criteria object used to create the INSERT statement.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static ObjectKey doInsert(Criteria criteria, Connection con)
        throws TorqueException
    {
        correctBooleans(criteria);

        setDbName(criteria);

        if (con == null)
        {
            return BasePeer.doInsert(criteria);
        }
        else
        {
            return BasePeer.doInsert(criteria, con);
        }
    }

    /**
     * Add all the columns needed to create a new object.
     *
     * @param criteria object containing the columns to add.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void addSelectColumns(Criteria criteria)
            throws TorqueException
    {
        criteria.addSelectColumn(ID);
        criteria.addSelectColumn(CONTENT);
        criteria.addSelectColumn(ANSWER);
        criteria.addSelectColumn(IMG);
        criteria.addSelectColumn(TIXING_ID);
        criteria.addSelectColumn(MATERIAL_ID);
        criteria.addSelectColumn(MATERIAL_KECHENG_ID);
        criteria.addSelectColumn(KNOWLEDGE_POINT_ID);
        criteria.addSelectColumn(WORDS_LEVEL);
        criteria.addSelectColumn(TAGS);
        criteria.addSelectColumn(FENCI);
        criteria.addSelectColumn(REMARK);
        criteria.addSelectColumn(MEMBER);
        criteria.addSelectColumn(CREATE_TIME);
        criteria.addSelectColumn(CREATE_MEMBER_ID);
        criteria.addSelectColumn(CREATE_MEMBER);
        criteria.addSelectColumn(MODIFY_TIME);
        criteria.addSelectColumn(MODIFY_MEMBER_ID);
        criteria.addSelectColumn(MODIFY_MEMBER);
        criteria.addSelectColumn(IMG_A);
        criteria.addSelectColumn(IMG_B);
        criteria.addSelectColumn(IMG_C);
        criteria.addSelectColumn(IMG_D);
        criteria.addSelectColumn(IMG_E);
        criteria.addSelectColumn(IMG_F);
        criteria.addSelectColumn(USED_TIMES);
    }

    /**
     * changes the boolean values in the criteria to the appropriate type,
     * whenever a booleanchar or booleanint column is involved.
     * This enables the user to create criteria using Boolean values
     * for booleanchar or booleanint columns
     * @param criteria the criteria in which the boolean values should be corrected
     * @throws TorqueException if the database map for the criteria cannot be 
               obtained.
     */
    public static void correctBooleans(Criteria criteria) throws TorqueException
    {
        correctBooleans(criteria, getTableMap());
    }

    /**
     * Create a new object of type cls from a resultset row starting
     * from a specified offset.  This is done so that you can select
     * other rows than just those needed for this object.  You may
     * for example want to create two objects from the same row.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static QuestionBank row2Object(Record row,
                                             int offset,
                                             Class cls)
        throws TorqueException
    {
        try
        {
            QuestionBank obj = (QuestionBank) cls.newInstance();
            QuestionBankPeer.populateObject(row, offset, obj);
                obj.setModified(false);
            obj.setNew(false);

            return obj;
        }
        catch (InstantiationException e)
        {
            throw new TorqueException(e);
        }
        catch (IllegalAccessException e)
        {
            throw new TorqueException(e);
        }
    }

    /**
     * Populates an object from a resultset row starting
     * from a specified offset.  This is done so that you can select
     * other rows than just those needed for this object.  You may
     * for example want to create two objects from the same row.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void populateObject(Record row,
                                      int offset,
                                      QuestionBank obj)
        throws TorqueException
    {
        try
        {
            obj.setId(row.getValue(offset + 0).asInt());
            obj.setContent(row.getValue(offset + 1).asString());
            obj.setAnswer(row.getValue(offset + 2).asString());
            obj.setImg(row.getValue(offset + 3).asString());
            obj.setTixingId(row.getValue(offset + 4).asInt());
            obj.setMaterialId(row.getValue(offset + 5).asInt());
            obj.setMaterialKechengId(row.getValue(offset + 6).asInt());
            obj.setKnowledgePointId(row.getValue(offset + 7).asString());
            obj.setWordsLevel(row.getValue(offset + 8).asString());
            obj.setTags(row.getValue(offset + 9).asString());
            obj.setFenci(row.getValue(offset + 10).asString());
            obj.setRemark(row.getValue(offset + 11).asString());
            obj.setMember(row.getValue(offset + 12).asString());
            obj.setCreateTime(row.getValue(offset + 13).asUtilDate());
            obj.setCreateMemberId(row.getValue(offset + 14).asInt());
            obj.setCreateMember(row.getValue(offset + 15).asString());
            obj.setModifyTime(row.getValue(offset + 16).asUtilDate());
            obj.setModifyMemberId(row.getValue(offset + 17).asInt());
            obj.setModifyMember(row.getValue(offset + 18).asString());
            obj.setImgA(row.getValue(offset + 19).asString());
            obj.setImgB(row.getValue(offset + 20).asString());
            obj.setImgC(row.getValue(offset + 21).asString());
            obj.setImgD(row.getValue(offset + 22).asString());
            obj.setImgE(row.getValue(offset + 23).asString());
            obj.setImgF(row.getValue(offset + 24).asString());
            obj.setUsedTimes(row.getValue(offset + 25).asInt());
        }
        catch (DataSetException e)
        {
            throw new TorqueException(e);
        }
    }

    /**
     * Method to do selects.
     *
     * @param criteria object used to create the SELECT statement.
     * @return List of selected Objects
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List doSelect(Criteria criteria) throws TorqueException
    {
        return populateObjects(doSelectVillageRecords(criteria));
    }

    /**
     * Method to do selects within a transaction.
     *
     * @param criteria object used to create the SELECT statement.
     * @param con the connection to use
     * @return List of selected Objects
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List doSelect(Criteria criteria, Connection con)
        throws TorqueException
    {
        return populateObjects(doSelectVillageRecords(criteria, con));
    }

    /**
     * Grabs the raw Village records to be formed into objects.
     * This method handles connections internally.  The Record objects
     * returned by this method should be considered readonly.  Do not
     * alter the data and call save(), your results may vary, but are
     * certainly likely to result in hard to track MT bugs.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List doSelectVillageRecords(Criteria criteria)
        throws TorqueException
    {
        return BaseQuestionBankPeer
            .doSelectVillageRecords(criteria, (Connection) null);
    }

    /**
     * Grabs the raw Village records to be formed into objects.
     * This method should be used for transactions
     *
     * @param criteria object used to create the SELECT statement.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List doSelectVillageRecords(Criteria criteria, Connection con)
        throws TorqueException
    {
        if (criteria.getSelectColumns().size() == 0)
        {
            addSelectColumns(criteria);
        }
        correctBooleans(criteria);

        setDbName(criteria);

        // BasePeer returns a List of Value (Village) arrays.  The array
        // order follows the order columns were placed in the Select clause.
        if (con == null)
        {
            return BasePeer.doSelect(criteria);
        }
        else
        {
            return BasePeer.doSelect(criteria, con);
        }
    }

    /**
     * The returned List will contain objects of the default type or
     * objects that inherit from the default.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List populateObjects(List records)
        throws TorqueException
    {
        List results = new ArrayList(records.size());

        // populate the object(s)
        for (int i = 0; i < records.size(); i++)
        {
            Record row = (Record) records.get(i);
            results.add(QuestionBankPeer.row2Object(row, 1,
                QuestionBankPeer.getOMClass()));
        }
        return results;
    }
 

    /**
     * The class that the Peer will make instances of.
     * If the BO is abstract then you must implement this method
     * in the BO.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static Class getOMClass()
        throws TorqueException
    {
        return CLASS_DEFAULT;
    }

    /**
     * Method to do updates.
     *
     * @param criteria object containing data that is used to create the UPDATE
     *        statement.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doUpdate(Criteria criteria) throws TorqueException
    {
         BaseQuestionBankPeer
            .doUpdate(criteria, (Connection) null);
    }

    /**
     * Method to do updates.  This method is to be used during a transaction,
     * otherwise use the doUpdate(Criteria) method.  It will take care of
     * the connection details internally.
     *
     * @param criteria object containing data that is used to create the UPDATE
     *        statement.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doUpdate(Criteria criteria, Connection con)
        throws TorqueException
    {
        Criteria selectCriteria = new Criteria(DATABASE_NAME, 2);
        correctBooleans(criteria);


         selectCriteria.put(ID, criteria.remove(ID));


























        setDbName(criteria);

        if (con == null)
        {
            BasePeer.doUpdate(selectCriteria, criteria);
        }
        else
        {
            BasePeer.doUpdate(selectCriteria, criteria, con);
        }
    }

    /**
     * Method to do deletes.
     *
     * @param criteria object containing data that is used DELETE from database.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
     public static void doDelete(Criteria criteria) throws TorqueException
     {
         QuestionBankPeer
            .doDelete(criteria, (Connection) null);
     }

    /**
     * Method to do deletes.  This method is to be used during a transaction,
     * otherwise use the doDelete(Criteria) method.  It will take care of
     * the connection details internally.
     *
     * @param criteria object containing data that is used DELETE from database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
     public static void doDelete(Criteria criteria, Connection con)
        throws TorqueException
     {
        correctBooleans(criteria);

        setDbName(criteria);

        if (con == null)
        {
            BasePeer.doDelete(criteria, TABLE_NAME);
        }
        else
        {
            BasePeer.doDelete(criteria, TABLE_NAME, con);
        }
     }

    /**
     * Method to do selects
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List doSelect(QuestionBank obj) throws TorqueException
    {
        return doSelect(buildSelectCriteria(obj));
    }

    /**
     * Method to do inserts
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doInsert(QuestionBank obj) throws TorqueException
    {
        obj.setPrimaryKey(doInsert(buildCriteria(obj)));
        obj.setNew(false);
        obj.setModified(false);
    }

    /**
     * @param obj the data object to update in the database.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doUpdate(QuestionBank obj) throws TorqueException
    {
        doUpdate(buildCriteria(obj));
        obj.setModified(false);
    }

    /**
     * @param obj the data object to delete in the database.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doDelete(QuestionBank obj) throws TorqueException
    {
        doDelete(buildSelectCriteria(obj));
    }

    /**
     * Method to do inserts.  This method is to be used during a transaction,
     * otherwise use the doInsert(QuestionBank) method.  It will take
     * care of the connection details internally.
     *
     * @param obj the data object to insert into the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doInsert(QuestionBank obj, Connection con)
        throws TorqueException
    {
        obj.setPrimaryKey(doInsert(buildCriteria(obj), con));
        obj.setNew(false);
        obj.setModified(false);
    }

    /**
     * Method to do update.  This method is to be used during a transaction,
     * otherwise use the doUpdate(QuestionBank) method.  It will take
     * care of the connection details internally.
     *
     * @param obj the data object to update in the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doUpdate(QuestionBank obj, Connection con)
        throws TorqueException
    {
        doUpdate(buildCriteria(obj), con);
        obj.setModified(false);
    }

    /**
     * Method to delete.  This method is to be used during a transaction,
     * otherwise use the doDelete(QuestionBank) method.  It will take
     * care of the connection details internally.
     *
     * @param obj the data object to delete in the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doDelete(QuestionBank obj, Connection con)
        throws TorqueException
    {
        doDelete(buildSelectCriteria(obj), con);
    }

    /**
     * Method to do deletes.
     *
     * @param pk ObjectKey that is used DELETE from database.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doDelete(ObjectKey pk) throws TorqueException
    {
        BaseQuestionBankPeer
           .doDelete(pk, (Connection) null);
    }

    /**
     * Method to delete.  This method is to be used during a transaction,
     * otherwise use the doDelete(ObjectKey) method.  It will take
     * care of the connection details internally.
     *
     * @param pk the primary key for the object to delete in the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doDelete(ObjectKey pk, Connection con)
        throws TorqueException
    {
        doDelete(buildCriteria(pk), con);
    }

    /** Build a Criteria object from an ObjectKey */
    public static Criteria buildCriteria( ObjectKey pk )
    {
        Criteria criteria = new Criteria();
            criteria.add(ID, pk);
        return criteria;
     }

    /** Build a Criteria object from the data object for this peer */
    public static Criteria buildCriteria( QuestionBank obj )
    {
        Criteria criteria = new Criteria(DATABASE_NAME);
        if (!obj.isNew())
        criteria.add(ID, obj.getId());
        criteria.add(CONTENT, obj.getContent());
        criteria.add(ANSWER, obj.getAnswer());
        criteria.add(IMG, obj.getImg());
        criteria.add(TIXING_ID, obj.getTixingId());
        criteria.add(MATERIAL_ID, obj.getMaterialId());
        criteria.add(MATERIAL_KECHENG_ID, obj.getMaterialKechengId());
        criteria.add(KNOWLEDGE_POINT_ID, obj.getKnowledgePointId());
        criteria.add(WORDS_LEVEL, obj.getWordsLevel());
        criteria.add(TAGS, obj.getTags());
        criteria.add(FENCI, obj.getFenci());
        criteria.add(REMARK, obj.getRemark());
        criteria.add(MEMBER, obj.getMember());
        criteria.add(CREATE_TIME, obj.getCreateTime());
        criteria.add(CREATE_MEMBER_ID, obj.getCreateMemberId());
        criteria.add(CREATE_MEMBER, obj.getCreateMember());
        criteria.add(MODIFY_TIME, obj.getModifyTime());
        criteria.add(MODIFY_MEMBER_ID, obj.getModifyMemberId());
        criteria.add(MODIFY_MEMBER, obj.getModifyMember());
        criteria.add(IMG_A, obj.getImgA());
        criteria.add(IMG_B, obj.getImgB());
        criteria.add(IMG_C, obj.getImgC());
        criteria.add(IMG_D, obj.getImgD());
        criteria.add(IMG_E, obj.getImgE());
        criteria.add(IMG_F, obj.getImgF());
        criteria.add(USED_TIMES, obj.getUsedTimes());
        return criteria;
    }

    /** Build a Criteria object from the data object for this peer, skipping all binary columns */
    public static Criteria buildSelectCriteria( QuestionBank obj )
    {
        Criteria criteria = new Criteria(DATABASE_NAME);
        if (!obj.isNew())
        {
            criteria.add(ID, obj.getId());
        }
            criteria.add(CONTENT, obj.getContent());
            criteria.add(ANSWER, obj.getAnswer());
            criteria.add(IMG, obj.getImg());
            criteria.add(TIXING_ID, obj.getTixingId());
            criteria.add(MATERIAL_ID, obj.getMaterialId());
            criteria.add(MATERIAL_KECHENG_ID, obj.getMaterialKechengId());
            criteria.add(KNOWLEDGE_POINT_ID, obj.getKnowledgePointId());
            criteria.add(WORDS_LEVEL, obj.getWordsLevel());
            criteria.add(TAGS, obj.getTags());
            criteria.add(FENCI, obj.getFenci());
            criteria.add(REMARK, obj.getRemark());
            criteria.add(MEMBER, obj.getMember());
            criteria.add(CREATE_TIME, obj.getCreateTime());
            criteria.add(CREATE_MEMBER_ID, obj.getCreateMemberId());
            criteria.add(CREATE_MEMBER, obj.getCreateMember());
            criteria.add(MODIFY_TIME, obj.getModifyTime());
            criteria.add(MODIFY_MEMBER_ID, obj.getModifyMemberId());
            criteria.add(MODIFY_MEMBER, obj.getModifyMember());
            criteria.add(IMG_A, obj.getImgA());
            criteria.add(IMG_B, obj.getImgB());
            criteria.add(IMG_C, obj.getImgC());
            criteria.add(IMG_D, obj.getImgD());
            criteria.add(IMG_E, obj.getImgE());
            criteria.add(IMG_F, obj.getImgF());
            criteria.add(USED_TIMES, obj.getUsedTimes());
        return criteria;
    }
 

    /**
     * Retrieve a single object by pk
     *
     * @param pk the primary key
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @throws NoRowsException Primary key was not found in database.
     * @throws TooManyRowsException Primary key was not found in database.
     */
    public static QuestionBank retrieveByPK(int pk)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        return retrieveByPK(SimpleKey.keyFor(pk));
    }

    /**
     * Retrieve a single object by pk
     *
     * @param pk the primary key
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @throws NoRowsException Primary key was not found in database.
     * @throws TooManyRowsException Primary key was not found in database.
     */
    public static QuestionBank retrieveByPK(int pk, Connection con)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        return retrieveByPK(SimpleKey.keyFor(pk), con);
    }

    /**
     * Retrieve a single object by pk
     *
     * @param pk the primary key
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @throws NoRowsException Primary key was not found in database.
     * @throws TooManyRowsException Primary key was not found in database.
     */
    public static QuestionBank retrieveByPK(ObjectKey pk)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        Connection db = null;
        QuestionBank retVal = null;
        try
        {
            db = Torque.getConnection(DATABASE_NAME);
            retVal = retrieveByPK(pk, db);
        }
        finally
        {
            Torque.closeConnection(db);
        }
        return retVal;
    }

    /**
     * Retrieve a single object by pk
     *
     * @param pk the primary key
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @throws NoRowsException Primary key was not found in database.
     * @throws TooManyRowsException Primary key was not found in database.
     */
    public static QuestionBank retrieveByPK(ObjectKey pk, Connection con)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        Criteria criteria = buildCriteria(pk);
        List v = doSelect(criteria, con);
        if (v.size() == 0)
        {
            throw new NoRowsException("Failed to select a row.");
        }
        else if (v.size() > 1)
        {
            throw new TooManyRowsException("Failed to select only one row.");
        }
        else
        {
            return (QuestionBank)v.get(0);
        }
    }

    /**
     * Retrieve a multiple objects by pk
     *
     * @param pks List of primary keys
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List retrieveByPKs(List pks)
        throws TorqueException
    {
        Connection db = null;
        List retVal = null;
        try
        {
           db = Torque.getConnection(DATABASE_NAME);
           retVal = retrieveByPKs(pks, db);
        }
        finally
        {
            Torque.closeConnection(db);
        }
        return retVal;
    }

    /**
     * Retrieve a multiple objects by pk
     *
     * @param pks List of primary keys
     * @param dbcon the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List retrieveByPKs( List pks, Connection dbcon )
        throws TorqueException
    {
        List objs = null;
        if (pks == null || pks.size() == 0)
        {
            objs = new LinkedList();
        }
        else
        {
            Criteria criteria = new Criteria();
            criteria.addIn( ID, pks );
        objs = doSelect(criteria, dbcon);
        }
        return objs;
    }

 








    /**
     * Returns the TableMap related to this peer.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static TableMap getTableMap()
        throws TorqueException
    {
        return Torque.getDatabaseMap(DATABASE_NAME).getTable(TABLE_NAME);
    }
 
    private static void setDbName(Criteria crit)
    {
        // Set the correct dbName if it has not been overridden
        // crit.getDbName will return the same object if not set to
        // another value so == check is okay and faster
        if (crit.getDbName() == Torque.getDefaultDB())
        {
            crit.setDbName(DATABASE_NAME);
        }
    }
    

}
