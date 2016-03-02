package com.hao.schoa.po;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.torque.NoRowsException;
import org.apache.torque.TooManyRowsException;
import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.TorqueRuntimeException;
import org.apache.torque.map.MapBuilder;
import org.apache.torque.map.TableMap;
import org.apache.torque.om.ObjectKey;
import org.apache.torque.om.SimpleKey;
import org.apache.torque.util.BasePeer;
import org.apache.torque.util.Criteria;

// Local classes
import com.hao.schoa.po.map.PaperAnalysisMapBuilder;
import com.workingdogs.village.DataSetException;
import com.workingdogs.village.QueryDataSet;
import com.workingdogs.village.Record;




/**
 */
public abstract class BasePaperAnalysisPeer
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
     * @deprecated Torque.getMapBuilder(PaperAnalysisMapBuilder.CLASS_NAME) instead
     */
    public static MapBuilder getMapBuilder()
        throws TorqueException
    {
        return Torque.getMapBuilder(PaperAnalysisMapBuilder.CLASS_NAME);
    }

    /** the column name for the id field */
    public static final String ID;
    /** the column name for the xueqi_id field */
    public static final String XUEQI_ID;
    /** the column name for the classes_id field */
    public static final String CLASSES_ID;
    /** the column name for the kecheng_id field */
    public static final String KECHENG_ID;
    /** the column name for the mingti_teacher field */
    public static final String MINGTI_TEACHER;
    /** the column name for the kaoshi_type field */
    public static final String KAOSHI_TYPE;
    /** the column name for the zl_01 field */
    public static final String ZL_01;
    /** the column name for the zl_02 field */
    public static final String ZL_02;
    /** the column name for the zl_03 field */
    public static final String ZL_03;
    /** the column name for the zl_04 field */
    public static final String ZL_04;
    /** the column name for the zl_05 field */
    public static final String ZL_05;
    /** the column name for the fen_90 field */
    public static final String FEN_90;
    /** the column name for the fen_90_bili field */
    public static final String FEN_90_BILI;
    /** the column name for the fen_8089 field */
    public static final String FEN_8089;
    /** the column name for the fen_8089_bili field */
    public static final String FEN_8089_BILI;
    /** the column name for the fen_7079 field */
    public static final String FEN_7079;
    /** the column name for the fen_7079_bili field */
    public static final String FEN_7079_BILI;
    /** the column name for the fen_6069 field */
    public static final String FEN_6069;
    /** the column name for the fen_6069_bili field */
    public static final String FEN_6069_BILI;
    /** the column name for the fen_59 field */
    public static final String FEN_59;
    /** the column name for the fen_59_bili field */
    public static final String FEN_59_BILI;
    /** the column name for the total field */
    public static final String TOTAL;
    /** the column name for the total_bili field */
    public static final String TOTAL_BILI;
    /** the column name for the fenxi_1 field */
    public static final String FENXI_1;
    /** the column name for the fenxi_2 field */
    public static final String FENXI_2;
    /** the column name for the member field */
    public static final String MEMBER;
    /** the column name for the update_time field */
    public static final String UPDATE_TIME;

    static
    {
        DATABASE_NAME = "schoa";
        TABLE_NAME = "paper_analysis";

        ID = "paper_analysis.id";
        XUEQI_ID = "paper_analysis.xueqi_id";
        CLASSES_ID = "paper_analysis.classes_id";
        KECHENG_ID = "paper_analysis.kecheng_id";
        MINGTI_TEACHER = "paper_analysis.mingti_teacher";
        KAOSHI_TYPE = "paper_analysis.kaoshi_type";
        ZL_01 = "paper_analysis.zl_01";
        ZL_02 = "paper_analysis.zl_02";
        ZL_03 = "paper_analysis.zl_03";
        ZL_04 = "paper_analysis.zl_04";
        ZL_05 = "paper_analysis.zl_05";
        FEN_90 = "paper_analysis.fen_90";
        FEN_90_BILI = "paper_analysis.fen_90_bili";
        FEN_8089 = "paper_analysis.fen_8089";
        FEN_8089_BILI = "paper_analysis.fen_8089_bili";
        FEN_7079 = "paper_analysis.fen_7079";
        FEN_7079_BILI = "paper_analysis.fen_7079_bili";
        FEN_6069 = "paper_analysis.fen_6069";
        FEN_6069_BILI = "paper_analysis.fen_6069_bili";
        FEN_59 = "paper_analysis.fen_59";
        FEN_59_BILI = "paper_analysis.fen_59_bili";
        TOTAL = "paper_analysis.total";
        TOTAL_BILI = "paper_analysis.total_bili";
        FENXI_1 = "paper_analysis.fenxi_1";
        FENXI_2 = "paper_analysis.fenxi_2";
        MEMBER = "paper_analysis.member";
        UPDATE_TIME = "paper_analysis.update_time";
        if (Torque.isInit())
        {
            try
            {
                Torque.getMapBuilder(PaperAnalysisMapBuilder.CLASS_NAME);
            }
            catch (TorqueException e)
            {
                log.error("Could not initialize Peer", e);
                throw new TorqueRuntimeException(e);
            }
        }
        else
        {
            Torque.registerMapBuilder(PaperAnalysisMapBuilder.CLASS_NAME);
        }
    }
 
    /** number of columns for this peer */
    public static final int numColumns =  27;

    /** A class that can be returned by this peer. */
    protected static final String CLASSNAME_DEFAULT =
        "com.hao.schoa.po.PaperAnalysis";

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
        return BasePaperAnalysisPeer
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
        criteria.addSelectColumn(XUEQI_ID);
        criteria.addSelectColumn(CLASSES_ID);
        criteria.addSelectColumn(KECHENG_ID);
        criteria.addSelectColumn(MINGTI_TEACHER);
        criteria.addSelectColumn(KAOSHI_TYPE);
        criteria.addSelectColumn(ZL_01);
        criteria.addSelectColumn(ZL_02);
        criteria.addSelectColumn(ZL_03);
        criteria.addSelectColumn(ZL_04);
        criteria.addSelectColumn(ZL_05);
        criteria.addSelectColumn(FEN_90);
        criteria.addSelectColumn(FEN_90_BILI);
        criteria.addSelectColumn(FEN_8089);
        criteria.addSelectColumn(FEN_8089_BILI);
        criteria.addSelectColumn(FEN_7079);
        criteria.addSelectColumn(FEN_7079_BILI);
        criteria.addSelectColumn(FEN_6069);
        criteria.addSelectColumn(FEN_6069_BILI);
        criteria.addSelectColumn(FEN_59);
        criteria.addSelectColumn(FEN_59_BILI);
        criteria.addSelectColumn(TOTAL);
        criteria.addSelectColumn(TOTAL_BILI);
        criteria.addSelectColumn(FENXI_1);
        criteria.addSelectColumn(FENXI_2);
        criteria.addSelectColumn(MEMBER);
        criteria.addSelectColumn(UPDATE_TIME);
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
    public static PaperAnalysis row2Object(Record row,
                                             int offset,
                                             Class cls)
        throws TorqueException
    {
        try
        {
            PaperAnalysis obj = (PaperAnalysis) cls.newInstance();
            PaperAnalysisPeer.populateObject(row, offset, obj);
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
                                      PaperAnalysis obj)
        throws TorqueException
    {
        try
        {
            obj.setId(row.getValue(offset + 0).asInt());
            obj.setXueqiId(row.getValue(offset + 1).asInt());
            obj.setClassesId(row.getValue(offset + 2).asInt());
            obj.setKechengId(row.getValue(offset + 3).asInt());
            obj.setMingtiTeacher(row.getValue(offset + 4).asString());
            obj.setKaoshiType(row.getValue(offset + 5).asString());
            obj.setZl01(row.getValue(offset + 6).asInt());
            obj.setZl02(row.getValue(offset + 7).asInt());
            obj.setZl03(row.getValue(offset + 8).asInt());
            obj.setZl04(row.getValue(offset + 9).asInt());
            obj.setZl05(row.getValue(offset + 10).asInt());
            obj.setFen90(row.getValue(offset + 11).asInt());
            obj.setFen90Bili(row.getValue(offset + 12).asDouble());
            obj.setFen8089(row.getValue(offset + 13).asInt());
            obj.setFen8089Bili(row.getValue(offset + 14).asDouble());
            obj.setFen7079(row.getValue(offset + 15).asInt());
            obj.setFen7079Bili(row.getValue(offset + 16).asDouble());
            obj.setFen6069(row.getValue(offset + 17).asInt());
            obj.setFen6069Bili(row.getValue(offset + 18).asDouble());
            obj.setFen59(row.getValue(offset + 19).asInt());
            obj.setFen59Bili(row.getValue(offset + 20).asDouble());
            obj.setTotal(row.getValue(offset + 21).asInt());
            obj.setTotalBili(row.getValue(offset + 22).asDouble());
            obj.setFenxi1(row.getValue(offset + 23).asString());
            obj.setFenxi2(row.getValue(offset + 24).asString());
            obj.setMember(row.getValue(offset + 25).asString());
            obj.setUpdateTime(row.getValue(offset + 26).asUtilDate());
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
        return BasePaperAnalysisPeer
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
            results.add(PaperAnalysisPeer.row2Object(row, 1,
                PaperAnalysisPeer.getOMClass()));
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
         BasePaperAnalysisPeer
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
         PaperAnalysisPeer
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
    public static List doSelect(PaperAnalysis obj) throws TorqueException
    {
        return doSelect(buildSelectCriteria(obj));
    }

    /**
     * Method to do inserts
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doInsert(PaperAnalysis obj) throws TorqueException
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
    public static void doUpdate(PaperAnalysis obj) throws TorqueException
    {
        doUpdate(buildCriteria(obj));
        obj.setModified(false);
    }

    /**
     * @param obj the data object to delete in the database.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doDelete(PaperAnalysis obj) throws TorqueException
    {
        doDelete(buildSelectCriteria(obj));
    }

    /**
     * Method to do inserts.  This method is to be used during a transaction,
     * otherwise use the doInsert(PaperAnalysis) method.  It will take
     * care of the connection details internally.
     *
     * @param obj the data object to insert into the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doInsert(PaperAnalysis obj, Connection con)
        throws TorqueException
    {
        obj.setPrimaryKey(doInsert(buildCriteria(obj), con));
        obj.setNew(false);
        obj.setModified(false);
    }

    /**
     * Method to do update.  This method is to be used during a transaction,
     * otherwise use the doUpdate(PaperAnalysis) method.  It will take
     * care of the connection details internally.
     *
     * @param obj the data object to update in the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doUpdate(PaperAnalysis obj, Connection con)
        throws TorqueException
    {
        doUpdate(buildCriteria(obj), con);
        obj.setModified(false);
    }

    /**
     * Method to delete.  This method is to be used during a transaction,
     * otherwise use the doDelete(PaperAnalysis) method.  It will take
     * care of the connection details internally.
     *
     * @param obj the data object to delete in the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doDelete(PaperAnalysis obj, Connection con)
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
        BasePaperAnalysisPeer
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
    public static Criteria buildCriteria( PaperAnalysis obj )
    {
        Criteria criteria = new Criteria(DATABASE_NAME);
        if (!obj.isNew())
        criteria.add(ID, obj.getId());
        criteria.add(XUEQI_ID, obj.getXueqiId());
        criteria.add(CLASSES_ID, obj.getClassesId());
        criteria.add(KECHENG_ID, obj.getKechengId());
        criteria.add(MINGTI_TEACHER, obj.getMingtiTeacher());
        criteria.add(KAOSHI_TYPE, obj.getKaoshiType());
        criteria.add(ZL_01, obj.getZl01());
        criteria.add(ZL_02, obj.getZl02());
        criteria.add(ZL_03, obj.getZl03());
        criteria.add(ZL_04, obj.getZl04());
        criteria.add(ZL_05, obj.getZl05());
        criteria.add(FEN_90, obj.getFen90());
        criteria.add(FEN_90_BILI, obj.getFen90Bili());
        criteria.add(FEN_8089, obj.getFen8089());
        criteria.add(FEN_8089_BILI, obj.getFen8089Bili());
        criteria.add(FEN_7079, obj.getFen7079());
        criteria.add(FEN_7079_BILI, obj.getFen7079Bili());
        criteria.add(FEN_6069, obj.getFen6069());
        criteria.add(FEN_6069_BILI, obj.getFen6069Bili());
        criteria.add(FEN_59, obj.getFen59());
        criteria.add(FEN_59_BILI, obj.getFen59Bili());
        criteria.add(TOTAL, obj.getTotal());
        criteria.add(TOTAL_BILI, obj.getTotalBili());
        criteria.add(FENXI_1, obj.getFenxi1());
        criteria.add(FENXI_2, obj.getFenxi2());
        criteria.add(MEMBER, obj.getMember());
        criteria.add(UPDATE_TIME, obj.getUpdateTime());
        return criteria;
    }

    /** Build a Criteria object from the data object for this peer, skipping all binary columns */
    public static Criteria buildSelectCriteria( PaperAnalysis obj )
    {
        Criteria criteria = new Criteria(DATABASE_NAME);
        if (!obj.isNew())
        {
            criteria.add(ID, obj.getId());
        }
            criteria.add(XUEQI_ID, obj.getXueqiId());
            criteria.add(CLASSES_ID, obj.getClassesId());
            criteria.add(KECHENG_ID, obj.getKechengId());
            criteria.add(MINGTI_TEACHER, obj.getMingtiTeacher());
            criteria.add(KAOSHI_TYPE, obj.getKaoshiType());
            criteria.add(ZL_01, obj.getZl01());
            criteria.add(ZL_02, obj.getZl02());
            criteria.add(ZL_03, obj.getZl03());
            criteria.add(ZL_04, obj.getZl04());
            criteria.add(ZL_05, obj.getZl05());
            criteria.add(FEN_90, obj.getFen90());
            criteria.add(FEN_90_BILI, obj.getFen90Bili());
            criteria.add(FEN_8089, obj.getFen8089());
            criteria.add(FEN_8089_BILI, obj.getFen8089Bili());
            criteria.add(FEN_7079, obj.getFen7079());
            criteria.add(FEN_7079_BILI, obj.getFen7079Bili());
            criteria.add(FEN_6069, obj.getFen6069());
            criteria.add(FEN_6069_BILI, obj.getFen6069Bili());
            criteria.add(FEN_59, obj.getFen59());
            criteria.add(FEN_59_BILI, obj.getFen59Bili());
            criteria.add(TOTAL, obj.getTotal());
            criteria.add(TOTAL_BILI, obj.getTotalBili());
            criteria.add(FENXI_1, obj.getFenxi1());
            criteria.add(FENXI_2, obj.getFenxi2());
            criteria.add(MEMBER, obj.getMember());
            criteria.add(UPDATE_TIME, obj.getUpdateTime());
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
    public static PaperAnalysis retrieveByPK(int pk)
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
    public static PaperAnalysis retrieveByPK(int pk, Connection con)
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
    public static PaperAnalysis retrieveByPK(ObjectKey pk)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        Connection db = null;
        PaperAnalysis retVal = null;
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
    public static PaperAnalysis retrieveByPK(ObjectKey pk, Connection con)
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
            return (PaperAnalysis)v.get(0);
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
