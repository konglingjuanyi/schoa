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
import com.hao.schoa.po.map.JiaoxueKaopinInfoMapBuilder;
import com.workingdogs.village.DataSetException;
import com.workingdogs.village.QueryDataSet;
import com.workingdogs.village.Record;




/**
 */
public abstract class BaseJiaoxueKaopinInfoPeer
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
     * @deprecated Torque.getMapBuilder(JiaoxueKaopinInfoMapBuilder.CLASS_NAME) instead
     */
    public static MapBuilder getMapBuilder()
        throws TorqueException
    {
        return Torque.getMapBuilder(JiaoxueKaopinInfoMapBuilder.CLASS_NAME);
    }

    /** the column name for the id field */
    public static final String ID;
    /** the column name for the kaopin_id field */
    public static final String KAOPIN_ID;
    /** the column name for the sum_score field */
    public static final String SUM_SCORE;
    /** the column name for the anshi field */
    public static final String ANSHI;
    /** the column name for the youyiyi field */
    public static final String YOUYIYI;
    /** the column name for the neirong field */
    public static final String NEIRONG;
    /** the column name for the shouhuo field */
    public static final String SHOUHUO;
    /** the column name for the shuohua_qingchu field */
    public static final String SHUOHUA_QINGCHU;
    /** the column name for the heibanzi_qingchu field */
    public static final String HEIBANZI_QINGCHU;
    /** the column name for the heibanzi_zhongyao field */
    public static final String HEIBANZI_ZHONGYAO;
    /** the column name for the shuliang_heshi field */
    public static final String SHULIANG_HESHI;
    /** the column name for the hanzi_jihui field */
    public static final String HANZI_JIHUI;
    /** the column name for the huodong_youxiao field */
    public static final String HUODONG_YOUXIAO;
    /** the column name for the zuoye_heshi field */
    public static final String ZUOYE_HESHI;
    /** the column name for the zuoye_bangzhu field */
    public static final String ZUOYE_BANGZHU;
    /** the column name for the naixin field */
    public static final String NAIXIN;
    /** the column name for the jinbu field */
    public static final String JINBU;
    /** the column name for the yange field */
    public static final String YANGE;
    /** the column name for the yuanyi field */
    public static final String YUANYI;
    /** the column name for the liaotian field */
    public static final String LIAOTIAN;
    /** the column name for the pingjia field */
    public static final String PINGJIA;
    /** the column name for the create_time field */
    public static final String CREATE_TIME;
    /** the column name for the man_id field */
    public static final String MAN_ID;
    /** the column name for the man_name field */
    public static final String MAN_NAME;
    /** the column name for the update_time field */
    public static final String UPDATE_TIME;

    static
    {
        DATABASE_NAME = "schoa";
        TABLE_NAME = "jiaoxue_kaopin_info";

        ID = "jiaoxue_kaopin_info.id";
        KAOPIN_ID = "jiaoxue_kaopin_info.kaopin_id";
        SUM_SCORE = "jiaoxue_kaopin_info.sum_score";
        ANSHI = "jiaoxue_kaopin_info.anshi";
        YOUYIYI = "jiaoxue_kaopin_info.youyiyi";
        NEIRONG = "jiaoxue_kaopin_info.neirong";
        SHOUHUO = "jiaoxue_kaopin_info.shouhuo";
        SHUOHUA_QINGCHU = "jiaoxue_kaopin_info.shuohua_qingchu";
        HEIBANZI_QINGCHU = "jiaoxue_kaopin_info.heibanzi_qingchu";
        HEIBANZI_ZHONGYAO = "jiaoxue_kaopin_info.heibanzi_zhongyao";
        SHULIANG_HESHI = "jiaoxue_kaopin_info.shuliang_heshi";
        HANZI_JIHUI = "jiaoxue_kaopin_info.hanzi_jihui";
        HUODONG_YOUXIAO = "jiaoxue_kaopin_info.huodong_youxiao";
        ZUOYE_HESHI = "jiaoxue_kaopin_info.zuoye_heshi";
        ZUOYE_BANGZHU = "jiaoxue_kaopin_info.zuoye_bangzhu";
        NAIXIN = "jiaoxue_kaopin_info.naixin";
        JINBU = "jiaoxue_kaopin_info.jinbu";
        YANGE = "jiaoxue_kaopin_info.yange";
        YUANYI = "jiaoxue_kaopin_info.yuanyi";
        LIAOTIAN = "jiaoxue_kaopin_info.liaotian";
        PINGJIA = "jiaoxue_kaopin_info.pingjia";
        CREATE_TIME = "jiaoxue_kaopin_info.create_time";
        MAN_ID = "jiaoxue_kaopin_info.man_id";
        MAN_NAME = "jiaoxue_kaopin_info.man_name";
        UPDATE_TIME = "jiaoxue_kaopin_info.update_time";
        if (Torque.isInit())
        {
            try
            {
                Torque.getMapBuilder(JiaoxueKaopinInfoMapBuilder.CLASS_NAME);
            }
            catch (TorqueException e)
            {
                log.error("Could not initialize Peer", e);
                throw new TorqueRuntimeException(e);
            }
        }
        else
        {
            Torque.registerMapBuilder(JiaoxueKaopinInfoMapBuilder.CLASS_NAME);
        }
    }
 
    /** number of columns for this peer */
    public static final int numColumns =  25;

    /** A class that can be returned by this peer. */
    protected static final String CLASSNAME_DEFAULT =
        "com.hao.schoa.po.JiaoxueKaopinInfo";

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
        return BaseJiaoxueKaopinInfoPeer
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
        criteria.addSelectColumn(KAOPIN_ID);
        criteria.addSelectColumn(SUM_SCORE);
        criteria.addSelectColumn(ANSHI);
        criteria.addSelectColumn(YOUYIYI);
        criteria.addSelectColumn(NEIRONG);
        criteria.addSelectColumn(SHOUHUO);
        criteria.addSelectColumn(SHUOHUA_QINGCHU);
        criteria.addSelectColumn(HEIBANZI_QINGCHU);
        criteria.addSelectColumn(HEIBANZI_ZHONGYAO);
        criteria.addSelectColumn(SHULIANG_HESHI);
        criteria.addSelectColumn(HANZI_JIHUI);
        criteria.addSelectColumn(HUODONG_YOUXIAO);
        criteria.addSelectColumn(ZUOYE_HESHI);
        criteria.addSelectColumn(ZUOYE_BANGZHU);
        criteria.addSelectColumn(NAIXIN);
        criteria.addSelectColumn(JINBU);
        criteria.addSelectColumn(YANGE);
        criteria.addSelectColumn(YUANYI);
        criteria.addSelectColumn(LIAOTIAN);
        criteria.addSelectColumn(PINGJIA);
        criteria.addSelectColumn(CREATE_TIME);
        criteria.addSelectColumn(MAN_ID);
        criteria.addSelectColumn(MAN_NAME);
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
    public static JiaoxueKaopinInfo row2Object(Record row,
                                             int offset,
                                             Class cls)
        throws TorqueException
    {
        try
        {
            JiaoxueKaopinInfo obj = (JiaoxueKaopinInfo) cls.newInstance();
            JiaoxueKaopinInfoPeer.populateObject(row, offset, obj);
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
                                      JiaoxueKaopinInfo obj)
        throws TorqueException
    {
        try
        {
            obj.setId(row.getValue(offset + 0).asInt());
            obj.setKaopinId(row.getValue(offset + 1).asInt());
            obj.setSumScore(row.getValue(offset + 2).asInt());
            obj.setAnshi(row.getValue(offset + 3).asInt());
            obj.setYouyiyi(row.getValue(offset + 4).asInt());
            obj.setNeirong(row.getValue(offset + 5).asInt());
            obj.setShouhuo(row.getValue(offset + 6).asInt());
            obj.setShuohuaQingchu(row.getValue(offset + 7).asInt());
            obj.setHeibanziQingchu(row.getValue(offset + 8).asInt());
            obj.setHeibanziZhongyao(row.getValue(offset + 9).asInt());
            obj.setShuliangHeshi(row.getValue(offset + 10).asInt());
            obj.setHanziJihui(row.getValue(offset + 11).asInt());
            obj.setHuodongYouxiao(row.getValue(offset + 12).asInt());
            obj.setZuoyeHeshi(row.getValue(offset + 13).asInt());
            obj.setZuoyeBangzhu(row.getValue(offset + 14).asInt());
            obj.setNaixin(row.getValue(offset + 15).asInt());
            obj.setJinbu(row.getValue(offset + 16).asInt());
            obj.setYange(row.getValue(offset + 17).asInt());
            obj.setYuanyi(row.getValue(offset + 18).asInt());
            obj.setLiaotian(row.getValue(offset + 19).asInt());
            obj.setPingjia(row.getValue(offset + 20).asString());
            obj.setCreateTime(row.getValue(offset + 21).asUtilDate());
            obj.setManId(row.getValue(offset + 22).asInt());
            obj.setManName(row.getValue(offset + 23).asString());
            obj.setUpdateTime(row.getValue(offset + 24).asUtilDate());
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
        return BaseJiaoxueKaopinInfoPeer
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
            results.add(JiaoxueKaopinInfoPeer.row2Object(row, 1,
                JiaoxueKaopinInfoPeer.getOMClass()));
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
         BaseJiaoxueKaopinInfoPeer
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
         JiaoxueKaopinInfoPeer
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
    public static List doSelect(JiaoxueKaopinInfo obj) throws TorqueException
    {
        return doSelect(buildSelectCriteria(obj));
    }

    /**
     * Method to do inserts
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doInsert(JiaoxueKaopinInfo obj) throws TorqueException
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
    public static void doUpdate(JiaoxueKaopinInfo obj) throws TorqueException
    {
        doUpdate(buildCriteria(obj));
        obj.setModified(false);
    }

    /**
     * @param obj the data object to delete in the database.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doDelete(JiaoxueKaopinInfo obj) throws TorqueException
    {
        doDelete(buildSelectCriteria(obj));
    }

    /**
     * Method to do inserts.  This method is to be used during a transaction,
     * otherwise use the doInsert(JiaoxueKaopinInfo) method.  It will take
     * care of the connection details internally.
     *
     * @param obj the data object to insert into the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doInsert(JiaoxueKaopinInfo obj, Connection con)
        throws TorqueException
    {
        obj.setPrimaryKey(doInsert(buildCriteria(obj), con));
        obj.setNew(false);
        obj.setModified(false);
    }

    /**
     * Method to do update.  This method is to be used during a transaction,
     * otherwise use the doUpdate(JiaoxueKaopinInfo) method.  It will take
     * care of the connection details internally.
     *
     * @param obj the data object to update in the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doUpdate(JiaoxueKaopinInfo obj, Connection con)
        throws TorqueException
    {
        doUpdate(buildCriteria(obj), con);
        obj.setModified(false);
    }

    /**
     * Method to delete.  This method is to be used during a transaction,
     * otherwise use the doDelete(JiaoxueKaopinInfo) method.  It will take
     * care of the connection details internally.
     *
     * @param obj the data object to delete in the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doDelete(JiaoxueKaopinInfo obj, Connection con)
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
        BaseJiaoxueKaopinInfoPeer
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
    public static Criteria buildCriteria( JiaoxueKaopinInfo obj )
    {
        Criteria criteria = new Criteria(DATABASE_NAME);
        if (!obj.isNew())
        criteria.add(ID, obj.getId());
        criteria.add(KAOPIN_ID, obj.getKaopinId());
        criteria.add(SUM_SCORE, obj.getSumScore());
        criteria.add(ANSHI, obj.getAnshi());
        criteria.add(YOUYIYI, obj.getYouyiyi());
        criteria.add(NEIRONG, obj.getNeirong());
        criteria.add(SHOUHUO, obj.getShouhuo());
        criteria.add(SHUOHUA_QINGCHU, obj.getShuohuaQingchu());
        criteria.add(HEIBANZI_QINGCHU, obj.getHeibanziQingchu());
        criteria.add(HEIBANZI_ZHONGYAO, obj.getHeibanziZhongyao());
        criteria.add(SHULIANG_HESHI, obj.getShuliangHeshi());
        criteria.add(HANZI_JIHUI, obj.getHanziJihui());
        criteria.add(HUODONG_YOUXIAO, obj.getHuodongYouxiao());
        criteria.add(ZUOYE_HESHI, obj.getZuoyeHeshi());
        criteria.add(ZUOYE_BANGZHU, obj.getZuoyeBangzhu());
        criteria.add(NAIXIN, obj.getNaixin());
        criteria.add(JINBU, obj.getJinbu());
        criteria.add(YANGE, obj.getYange());
        criteria.add(YUANYI, obj.getYuanyi());
        criteria.add(LIAOTIAN, obj.getLiaotian());
        criteria.add(PINGJIA, obj.getPingjia());
        criteria.add(CREATE_TIME, obj.getCreateTime());
        criteria.add(MAN_ID, obj.getManId());
        criteria.add(MAN_NAME, obj.getManName());
        criteria.add(UPDATE_TIME, obj.getUpdateTime());
        return criteria;
    }

    /** Build a Criteria object from the data object for this peer, skipping all binary columns */
    public static Criteria buildSelectCriteria( JiaoxueKaopinInfo obj )
    {
        Criteria criteria = new Criteria(DATABASE_NAME);
        if (!obj.isNew())
        {
            criteria.add(ID, obj.getId());
        }
            criteria.add(KAOPIN_ID, obj.getKaopinId());
            criteria.add(SUM_SCORE, obj.getSumScore());
            criteria.add(ANSHI, obj.getAnshi());
            criteria.add(YOUYIYI, obj.getYouyiyi());
            criteria.add(NEIRONG, obj.getNeirong());
            criteria.add(SHOUHUO, obj.getShouhuo());
            criteria.add(SHUOHUA_QINGCHU, obj.getShuohuaQingchu());
            criteria.add(HEIBANZI_QINGCHU, obj.getHeibanziQingchu());
            criteria.add(HEIBANZI_ZHONGYAO, obj.getHeibanziZhongyao());
            criteria.add(SHULIANG_HESHI, obj.getShuliangHeshi());
            criteria.add(HANZI_JIHUI, obj.getHanziJihui());
            criteria.add(HUODONG_YOUXIAO, obj.getHuodongYouxiao());
            criteria.add(ZUOYE_HESHI, obj.getZuoyeHeshi());
            criteria.add(ZUOYE_BANGZHU, obj.getZuoyeBangzhu());
            criteria.add(NAIXIN, obj.getNaixin());
            criteria.add(JINBU, obj.getJinbu());
            criteria.add(YANGE, obj.getYange());
            criteria.add(YUANYI, obj.getYuanyi());
            criteria.add(LIAOTIAN, obj.getLiaotian());
            criteria.add(PINGJIA, obj.getPingjia());
            criteria.add(CREATE_TIME, obj.getCreateTime());
            criteria.add(MAN_ID, obj.getManId());
            criteria.add(MAN_NAME, obj.getManName());
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
    public static JiaoxueKaopinInfo retrieveByPK(int pk)
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
    public static JiaoxueKaopinInfo retrieveByPK(int pk, Connection con)
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
    public static JiaoxueKaopinInfo retrieveByPK(ObjectKey pk)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        Connection db = null;
        JiaoxueKaopinInfo retVal = null;
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
    public static JiaoxueKaopinInfo retrieveByPK(ObjectKey pk, Connection con)
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
            return (JiaoxueKaopinInfo)v.get(0);
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
