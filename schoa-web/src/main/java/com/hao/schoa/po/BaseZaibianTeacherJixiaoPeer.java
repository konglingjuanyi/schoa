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
import com.hao.schoa.po.map.ZaibianTeacherJixiaoMapBuilder;
import com.workingdogs.village.DataSetException;
import com.workingdogs.village.QueryDataSet;
import com.workingdogs.village.Record;




/**
 */
public abstract class BaseZaibianTeacherJixiaoPeer
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
     * @deprecated Torque.getMapBuilder(ZaibianTeacherJixiaoMapBuilder.CLASS_NAME) instead
     */
    public static MapBuilder getMapBuilder()
        throws TorqueException
    {
        return Torque.getMapBuilder(ZaibianTeacherJixiaoMapBuilder.CLASS_NAME);
    }

    /** the column name for the id field */
    public static final String ID;
    /** the column name for the youxiu field */
    public static final String YOUXIU;
    /** the column name for the xueqi_id field */
    public static final String XUEQI_ID;
    /** the column name for the banji_id field */
    public static final String BANJI_ID;
    /** the column name for the kecheng_id field */
    public static final String KECHENG_ID;
    /** the column name for the teacher_id field */
    public static final String TEACHER_ID;
    /** the column name for the teacher_name field */
    public static final String TEACHER_NAME;
    /** the column name for the sc_kaopin field */
    public static final String SC_KAOPIN;
    /** the column name for the sc_chuqin field */
    public static final String SC_CHUQIN;
    /** the column name for the sc_jiaoxuefile field */
    public static final String SC_JIAOXUEFILE;
    /** the column name for the sc_tingke field */
    public static final String SC_TINGKE;
    /** the column name for the sc_kaihui_reason field */
    public static final String SC_KAIHUI_REASON;
    /** the column name for the sc_banzhuren field */
    public static final String SC_BANZHUREN;
    /** the column name for the sc_jianren field */
    public static final String SC_JIANREN;
    /** the column name for the sc_other field */
    public static final String SC_OTHER;
    /** the column name for the sc_jiang field */
    public static final String SC_JIANG;
    /** the column name for the sc_gongzuoliang field */
    public static final String SC_GONGZUOLIANG;
    /** the column name for the sc_kaohe_file field */
    public static final String SC_KAOHE_FILE;
    /** the column name for the sc_kaohe_filename field */
    public static final String SC_KAOHE_FILENAME;
    /** the column name for the remark field */
    public static final String REMARK;
    /** the column name for the member_id field */
    public static final String MEMBER_ID;
    /** the column name for the member_name field */
    public static final String MEMBER_NAME;
    /** the column name for the update_time field */
    public static final String UPDATE_TIME;

    static
    {
        DATABASE_NAME = "schoa";
        TABLE_NAME = "zaibian_teacher_jixiao";

        ID = "zaibian_teacher_jixiao.id";
        YOUXIU = "zaibian_teacher_jixiao.youxiu";
        XUEQI_ID = "zaibian_teacher_jixiao.xueqi_id";
        BANJI_ID = "zaibian_teacher_jixiao.banji_id";
        KECHENG_ID = "zaibian_teacher_jixiao.kecheng_id";
        TEACHER_ID = "zaibian_teacher_jixiao.teacher_id";
        TEACHER_NAME = "zaibian_teacher_jixiao.teacher_name";
        SC_KAOPIN = "zaibian_teacher_jixiao.sc_kaopin";
        SC_CHUQIN = "zaibian_teacher_jixiao.sc_chuqin";
        SC_JIAOXUEFILE = "zaibian_teacher_jixiao.sc_jiaoxuefile";
        SC_TINGKE = "zaibian_teacher_jixiao.sc_tingke";
        SC_KAIHUI_REASON = "zaibian_teacher_jixiao.sc_kaihui_reason";
        SC_BANZHUREN = "zaibian_teacher_jixiao.sc_banzhuren";
        SC_JIANREN = "zaibian_teacher_jixiao.sc_jianren";
        SC_OTHER = "zaibian_teacher_jixiao.sc_other";
        SC_JIANG = "zaibian_teacher_jixiao.sc_jiang";
        SC_GONGZUOLIANG = "zaibian_teacher_jixiao.sc_gongzuoliang";
        SC_KAOHE_FILE = "zaibian_teacher_jixiao.sc_kaohe_file";
        SC_KAOHE_FILENAME = "zaibian_teacher_jixiao.sc_kaohe_filename";
        REMARK = "zaibian_teacher_jixiao.remark";
        MEMBER_ID = "zaibian_teacher_jixiao.member_id";
        MEMBER_NAME = "zaibian_teacher_jixiao.member_name";
        UPDATE_TIME = "zaibian_teacher_jixiao.update_time";
        if (Torque.isInit())
        {
            try
            {
                Torque.getMapBuilder(ZaibianTeacherJixiaoMapBuilder.CLASS_NAME);
            }
            catch (TorqueException e)
            {
                log.error("Could not initialize Peer", e);
                throw new TorqueRuntimeException(e);
            }
        }
        else
        {
            Torque.registerMapBuilder(ZaibianTeacherJixiaoMapBuilder.CLASS_NAME);
        }
    }
 
    /** number of columns for this peer */
    public static final int numColumns =  23;

    /** A class that can be returned by this peer. */
    protected static final String CLASSNAME_DEFAULT =
        "com.hao.schoa.po.ZaibianTeacherJixiao";

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
        return BaseZaibianTeacherJixiaoPeer
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
        criteria.addSelectColumn(YOUXIU);
        criteria.addSelectColumn(XUEQI_ID);
        criteria.addSelectColumn(BANJI_ID);
        criteria.addSelectColumn(KECHENG_ID);
        criteria.addSelectColumn(TEACHER_ID);
        criteria.addSelectColumn(TEACHER_NAME);
        criteria.addSelectColumn(SC_KAOPIN);
        criteria.addSelectColumn(SC_CHUQIN);
        criteria.addSelectColumn(SC_JIAOXUEFILE);
        criteria.addSelectColumn(SC_TINGKE);
        criteria.addSelectColumn(SC_KAIHUI_REASON);
        criteria.addSelectColumn(SC_BANZHUREN);
        criteria.addSelectColumn(SC_JIANREN);
        criteria.addSelectColumn(SC_OTHER);
        criteria.addSelectColumn(SC_JIANG);
        criteria.addSelectColumn(SC_GONGZUOLIANG);
        criteria.addSelectColumn(SC_KAOHE_FILE);
        criteria.addSelectColumn(SC_KAOHE_FILENAME);
        criteria.addSelectColumn(REMARK);
        criteria.addSelectColumn(MEMBER_ID);
        criteria.addSelectColumn(MEMBER_NAME);
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
    public static ZaibianTeacherJixiao row2Object(Record row,
                                             int offset,
                                             Class cls)
        throws TorqueException
    {
        try
        {
            ZaibianTeacherJixiao obj = (ZaibianTeacherJixiao) cls.newInstance();
            ZaibianTeacherJixiaoPeer.populateObject(row, offset, obj);
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
                                      ZaibianTeacherJixiao obj)
        throws TorqueException
    {
        try
        {
            obj.setId(row.getValue(offset + 0).asInt());
            obj.setYouxiu(row.getValue(offset + 1).asInt());
            obj.setXueqiId(row.getValue(offset + 2).asInt());
            obj.setBanjiId(row.getValue(offset + 3).asInt());
            obj.setKechengId(row.getValue(offset + 4).asInt());
            obj.setTeacherId(row.getValue(offset + 5).asInt());
            obj.setTeacherName(row.getValue(offset + 6).asString());
            obj.setScKaopin(row.getValue(offset + 7).asDouble());
            obj.setScChuqin(row.getValue(offset + 8).asDouble());
            obj.setScJiaoxuefile(row.getValue(offset + 9).asDouble());
            obj.setScTingke(row.getValue(offset + 10).asDouble());
            obj.setScKaihuiReason(row.getValue(offset + 11).asString());
            obj.setScBanzhuren(row.getValue(offset + 12).asString());
            obj.setScJianren(row.getValue(offset + 13).asString());
            obj.setScOther(row.getValue(offset + 14).asString());
            obj.setScJiang(row.getValue(offset + 15).asString());
            obj.setScGongzuoliang(row.getValue(offset + 16).asString());
            obj.setScKaoheFile(row.getValue(offset + 17).asString());
            obj.setScKaoheFilename(row.getValue(offset + 18).asString());
            obj.setRemark(row.getValue(offset + 19).asString());
            obj.setMemberId(row.getValue(offset + 20).asInt());
            obj.setMemberName(row.getValue(offset + 21).asString());
            obj.setUpdateTime(row.getValue(offset + 22).asUtilDate());
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
        return BaseZaibianTeacherJixiaoPeer
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
            results.add(ZaibianTeacherJixiaoPeer.row2Object(row, 1,
                ZaibianTeacherJixiaoPeer.getOMClass()));
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
         BaseZaibianTeacherJixiaoPeer
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
         ZaibianTeacherJixiaoPeer
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
    public static List doSelect(ZaibianTeacherJixiao obj) throws TorqueException
    {
        return doSelect(buildSelectCriteria(obj));
    }

    /**
     * Method to do inserts
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doInsert(ZaibianTeacherJixiao obj) throws TorqueException
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
    public static void doUpdate(ZaibianTeacherJixiao obj) throws TorqueException
    {
        doUpdate(buildCriteria(obj));
        obj.setModified(false);
    }

    /**
     * @param obj the data object to delete in the database.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doDelete(ZaibianTeacherJixiao obj) throws TorqueException
    {
        doDelete(buildSelectCriteria(obj));
    }

    /**
     * Method to do inserts.  This method is to be used during a transaction,
     * otherwise use the doInsert(ZaibianTeacherJixiao) method.  It will take
     * care of the connection details internally.
     *
     * @param obj the data object to insert into the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doInsert(ZaibianTeacherJixiao obj, Connection con)
        throws TorqueException
    {
        obj.setPrimaryKey(doInsert(buildCriteria(obj), con));
        obj.setNew(false);
        obj.setModified(false);
    }

    /**
     * Method to do update.  This method is to be used during a transaction,
     * otherwise use the doUpdate(ZaibianTeacherJixiao) method.  It will take
     * care of the connection details internally.
     *
     * @param obj the data object to update in the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doUpdate(ZaibianTeacherJixiao obj, Connection con)
        throws TorqueException
    {
        doUpdate(buildCriteria(obj), con);
        obj.setModified(false);
    }

    /**
     * Method to delete.  This method is to be used during a transaction,
     * otherwise use the doDelete(ZaibianTeacherJixiao) method.  It will take
     * care of the connection details internally.
     *
     * @param obj the data object to delete in the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doDelete(ZaibianTeacherJixiao obj, Connection con)
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
        BaseZaibianTeacherJixiaoPeer
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
    public static Criteria buildCriteria( ZaibianTeacherJixiao obj )
    {
        Criteria criteria = new Criteria(DATABASE_NAME);
        if (!obj.isNew())
        criteria.add(ID, obj.getId());
        criteria.add(YOUXIU, obj.getYouxiu());
        criteria.add(XUEQI_ID, obj.getXueqiId());
        criteria.add(BANJI_ID, obj.getBanjiId());
        criteria.add(KECHENG_ID, obj.getKechengId());
        criteria.add(TEACHER_ID, obj.getTeacherId());
        criteria.add(TEACHER_NAME, obj.getTeacherName());
        criteria.add(SC_KAOPIN, obj.getScKaopin());
        criteria.add(SC_CHUQIN, obj.getScChuqin());
        criteria.add(SC_JIAOXUEFILE, obj.getScJiaoxuefile());
        criteria.add(SC_TINGKE, obj.getScTingke());
        criteria.add(SC_KAIHUI_REASON, obj.getScKaihuiReason());
        criteria.add(SC_BANZHUREN, obj.getScBanzhuren());
        criteria.add(SC_JIANREN, obj.getScJianren());
        criteria.add(SC_OTHER, obj.getScOther());
        criteria.add(SC_JIANG, obj.getScJiang());
        criteria.add(SC_GONGZUOLIANG, obj.getScGongzuoliang());
        criteria.add(SC_KAOHE_FILE, obj.getScKaoheFile());
        criteria.add(SC_KAOHE_FILENAME, obj.getScKaoheFilename());
        criteria.add(REMARK, obj.getRemark());
        criteria.add(MEMBER_ID, obj.getMemberId());
        criteria.add(MEMBER_NAME, obj.getMemberName());
        criteria.add(UPDATE_TIME, obj.getUpdateTime());
        return criteria;
    }

    /** Build a Criteria object from the data object for this peer, skipping all binary columns */
    public static Criteria buildSelectCriteria( ZaibianTeacherJixiao obj )
    {
        Criteria criteria = new Criteria(DATABASE_NAME);
        if (!obj.isNew())
        {
            criteria.add(ID, obj.getId());
        }
            criteria.add(YOUXIU, obj.getYouxiu());
            criteria.add(XUEQI_ID, obj.getXueqiId());
            criteria.add(BANJI_ID, obj.getBanjiId());
            criteria.add(KECHENG_ID, obj.getKechengId());
            criteria.add(TEACHER_ID, obj.getTeacherId());
            criteria.add(TEACHER_NAME, obj.getTeacherName());
            criteria.add(SC_KAOPIN, obj.getScKaopin());
            criteria.add(SC_CHUQIN, obj.getScChuqin());
            criteria.add(SC_JIAOXUEFILE, obj.getScJiaoxuefile());
            criteria.add(SC_TINGKE, obj.getScTingke());
            criteria.add(SC_KAIHUI_REASON, obj.getScKaihuiReason());
            criteria.add(SC_BANZHUREN, obj.getScBanzhuren());
            criteria.add(SC_JIANREN, obj.getScJianren());
            criteria.add(SC_OTHER, obj.getScOther());
            criteria.add(SC_JIANG, obj.getScJiang());
            criteria.add(SC_GONGZUOLIANG, obj.getScGongzuoliang());
            criteria.add(SC_KAOHE_FILE, obj.getScKaoheFile());
            criteria.add(SC_KAOHE_FILENAME, obj.getScKaoheFilename());
            criteria.add(REMARK, obj.getRemark());
            criteria.add(MEMBER_ID, obj.getMemberId());
            criteria.add(MEMBER_NAME, obj.getMemberName());
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
    public static ZaibianTeacherJixiao retrieveByPK(int pk)
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
    public static ZaibianTeacherJixiao retrieveByPK(int pk, Connection con)
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
    public static ZaibianTeacherJixiao retrieveByPK(ObjectKey pk)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        Connection db = null;
        ZaibianTeacherJixiao retVal = null;
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
    public static ZaibianTeacherJixiao retrieveByPK(ObjectKey pk, Connection con)
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
            return (ZaibianTeacherJixiao)v.get(0);
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
