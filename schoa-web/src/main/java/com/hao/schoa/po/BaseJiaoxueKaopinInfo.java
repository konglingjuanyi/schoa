package com.hao.schoa.po;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.torque.TorqueException;
import org.apache.torque.map.TableMap;
import org.apache.torque.om.BaseObject;
import org.apache.torque.om.NumberKey;
import org.apache.torque.om.ObjectKey;
import org.apache.torque.om.SimpleKey;
import org.apache.torque.util.Transaction;





/**
 * You should not use this class directly.  It should not even be
 * extended all references should be to JiaoxueKaopinInfo
 */
public abstract class BaseJiaoxueKaopinInfo extends BaseObject
{
    /** The Peer class */
    private static final JiaoxueKaopinInfoPeer peer =
        new JiaoxueKaopinInfoPeer();


    /** The value for the id field */
    private int id;

    /** The value for the kaopinId field */
    private int kaopinId = 0;

    /** The value for the sumScore field */
    private int sumScore = 0;

    /** The value for the anshi field */
    private int anshi = 0;

    /** The value for the youyiyi field */
    private int youyiyi = 0;

    /** The value for the neirong field */
    private int neirong = 0;

    /** The value for the shouhuo field */
    private int shouhuo = 0;

    /** The value for the shuohuaQingchu field */
    private int shuohuaQingchu = 0;

    /** The value for the heibanziQingchu field */
    private int heibanziQingchu = 0;

    /** The value for the heibanziZhongyao field */
    private int heibanziZhongyao = 0;

    /** The value for the shuliangHeshi field */
    private int shuliangHeshi = 0;

    /** The value for the hanziJihui field */
    private int hanziJihui = 0;

    /** The value for the huodongYouxiao field */
    private int huodongYouxiao = 0;

    /** The value for the zuoyeHeshi field */
    private int zuoyeHeshi = 0;

    /** The value for the zuoyeBangzhu field */
    private int zuoyeBangzhu = 0;

    /** The value for the naixin field */
    private int naixin = 0;

    /** The value for the jinbu field */
    private int jinbu = 0;

    /** The value for the yange field */
    private int yange = 0;

    /** The value for the yuanyi field */
    private int yuanyi = 0;

    /** The value for the liaotian field */
    private int liaotian = 0;

    /** The value for the pingjia field */
    private String pingjia;

    /** The value for the createTime field */
    private Date createTime;

    /** The value for the manId field */
    private int manId;

    /** The value for the manName field */
    private String manName;

    /** The value for the updateTime field */
    private Date updateTime;


    /**
     * Get the Id
     *
     * @return int
     */
    public int getId()
    {
        return id;
    }


    /**
     * Set the value of Id
     *
     * @param v new value
     */
    public void setId(int v) 
    {

        if (this.id != v)
        {
            this.id = v;
            setModified(true);
        }


    }

    /**
     * Get the KaopinId
     *
     * @return int
     */
    public int getKaopinId()
    {
        return kaopinId;
    }


    /**
     * Set the value of KaopinId
     *
     * @param v new value
     */
    public void setKaopinId(int v) 
    {

        if (this.kaopinId != v)
        {
            this.kaopinId = v;
            setModified(true);
        }


    }

    /**
     * Get the SumScore
     *
     * @return int
     */
    public int getSumScore()
    {
        return sumScore;
    }


    /**
     * Set the value of SumScore
     *
     * @param v new value
     */
    public void setSumScore(int v) 
    {

        if (this.sumScore != v)
        {
            this.sumScore = v;
            setModified(true);
        }


    }

    /**
     * Get the Anshi
     *
     * @return int
     */
    public int getAnshi()
    {
        return anshi;
    }


    /**
     * Set the value of Anshi
     *
     * @param v new value
     */
    public void setAnshi(int v) 
    {

        if (this.anshi != v)
        {
            this.anshi = v;
            setModified(true);
        }


    }

    /**
     * Get the Youyiyi
     *
     * @return int
     */
    public int getYouyiyi()
    {
        return youyiyi;
    }


    /**
     * Set the value of Youyiyi
     *
     * @param v new value
     */
    public void setYouyiyi(int v) 
    {

        if (this.youyiyi != v)
        {
            this.youyiyi = v;
            setModified(true);
        }


    }

    /**
     * Get the Neirong
     *
     * @return int
     */
    public int getNeirong()
    {
        return neirong;
    }


    /**
     * Set the value of Neirong
     *
     * @param v new value
     */
    public void setNeirong(int v) 
    {

        if (this.neirong != v)
        {
            this.neirong = v;
            setModified(true);
        }


    }

    /**
     * Get the Shouhuo
     *
     * @return int
     */
    public int getShouhuo()
    {
        return shouhuo;
    }


    /**
     * Set the value of Shouhuo
     *
     * @param v new value
     */
    public void setShouhuo(int v) 
    {

        if (this.shouhuo != v)
        {
            this.shouhuo = v;
            setModified(true);
        }


    }

    /**
     * Get the ShuohuaQingchu
     *
     * @return int
     */
    public int getShuohuaQingchu()
    {
        return shuohuaQingchu;
    }


    /**
     * Set the value of ShuohuaQingchu
     *
     * @param v new value
     */
    public void setShuohuaQingchu(int v) 
    {

        if (this.shuohuaQingchu != v)
        {
            this.shuohuaQingchu = v;
            setModified(true);
        }


    }

    /**
     * Get the HeibanziQingchu
     *
     * @return int
     */
    public int getHeibanziQingchu()
    {
        return heibanziQingchu;
    }


    /**
     * Set the value of HeibanziQingchu
     *
     * @param v new value
     */
    public void setHeibanziQingchu(int v) 
    {

        if (this.heibanziQingchu != v)
        {
            this.heibanziQingchu = v;
            setModified(true);
        }


    }

    /**
     * Get the HeibanziZhongyao
     *
     * @return int
     */
    public int getHeibanziZhongyao()
    {
        return heibanziZhongyao;
    }


    /**
     * Set the value of HeibanziZhongyao
     *
     * @param v new value
     */
    public void setHeibanziZhongyao(int v) 
    {

        if (this.heibanziZhongyao != v)
        {
            this.heibanziZhongyao = v;
            setModified(true);
        }


    }

    /**
     * Get the ShuliangHeshi
     *
     * @return int
     */
    public int getShuliangHeshi()
    {
        return shuliangHeshi;
    }


    /**
     * Set the value of ShuliangHeshi
     *
     * @param v new value
     */
    public void setShuliangHeshi(int v) 
    {

        if (this.shuliangHeshi != v)
        {
            this.shuliangHeshi = v;
            setModified(true);
        }


    }

    /**
     * Get the HanziJihui
     *
     * @return int
     */
    public int getHanziJihui()
    {
        return hanziJihui;
    }


    /**
     * Set the value of HanziJihui
     *
     * @param v new value
     */
    public void setHanziJihui(int v) 
    {

        if (this.hanziJihui != v)
        {
            this.hanziJihui = v;
            setModified(true);
        }


    }

    /**
     * Get the HuodongYouxiao
     *
     * @return int
     */
    public int getHuodongYouxiao()
    {
        return huodongYouxiao;
    }


    /**
     * Set the value of HuodongYouxiao
     *
     * @param v new value
     */
    public void setHuodongYouxiao(int v) 
    {

        if (this.huodongYouxiao != v)
        {
            this.huodongYouxiao = v;
            setModified(true);
        }


    }

    /**
     * Get the ZuoyeHeshi
     *
     * @return int
     */
    public int getZuoyeHeshi()
    {
        return zuoyeHeshi;
    }


    /**
     * Set the value of ZuoyeHeshi
     *
     * @param v new value
     */
    public void setZuoyeHeshi(int v) 
    {

        if (this.zuoyeHeshi != v)
        {
            this.zuoyeHeshi = v;
            setModified(true);
        }


    }

    /**
     * Get the ZuoyeBangzhu
     *
     * @return int
     */
    public int getZuoyeBangzhu()
    {
        return zuoyeBangzhu;
    }


    /**
     * Set the value of ZuoyeBangzhu
     *
     * @param v new value
     */
    public void setZuoyeBangzhu(int v) 
    {

        if (this.zuoyeBangzhu != v)
        {
            this.zuoyeBangzhu = v;
            setModified(true);
        }


    }

    /**
     * Get the Naixin
     *
     * @return int
     */
    public int getNaixin()
    {
        return naixin;
    }


    /**
     * Set the value of Naixin
     *
     * @param v new value
     */
    public void setNaixin(int v) 
    {

        if (this.naixin != v)
        {
            this.naixin = v;
            setModified(true);
        }


    }

    /**
     * Get the Jinbu
     *
     * @return int
     */
    public int getJinbu()
    {
        return jinbu;
    }


    /**
     * Set the value of Jinbu
     *
     * @param v new value
     */
    public void setJinbu(int v) 
    {

        if (this.jinbu != v)
        {
            this.jinbu = v;
            setModified(true);
        }


    }

    /**
     * Get the Yange
     *
     * @return int
     */
    public int getYange()
    {
        return yange;
    }


    /**
     * Set the value of Yange
     *
     * @param v new value
     */
    public void setYange(int v) 
    {

        if (this.yange != v)
        {
            this.yange = v;
            setModified(true);
        }


    }

    /**
     * Get the Yuanyi
     *
     * @return int
     */
    public int getYuanyi()
    {
        return yuanyi;
    }


    /**
     * Set the value of Yuanyi
     *
     * @param v new value
     */
    public void setYuanyi(int v) 
    {

        if (this.yuanyi != v)
        {
            this.yuanyi = v;
            setModified(true);
        }


    }

    /**
     * Get the Liaotian
     *
     * @return int
     */
    public int getLiaotian()
    {
        return liaotian;
    }


    /**
     * Set the value of Liaotian
     *
     * @param v new value
     */
    public void setLiaotian(int v) 
    {

        if (this.liaotian != v)
        {
            this.liaotian = v;
            setModified(true);
        }


    }

    /**
     * Get the Pingjia
     *
     * @return String
     */
    public String getPingjia()
    {
        return pingjia;
    }


    /**
     * Set the value of Pingjia
     *
     * @param v new value
     */
    public void setPingjia(String v) 
    {

        if (!ObjectUtils.equals(this.pingjia, v))
        {
            this.pingjia = v;
            setModified(true);
        }


    }

    /**
     * Get the CreateTime
     *
     * @return Date
     */
    public Date getCreateTime()
    {
        return createTime;
    }


    /**
     * Set the value of CreateTime
     *
     * @param v new value
     */
    public void setCreateTime(Date v) 
    {

        if (!ObjectUtils.equals(this.createTime, v))
        {
            this.createTime = v;
            setModified(true);
        }


    }

    /**
     * Get the ManId
     *
     * @return int
     */
    public int getManId()
    {
        return manId;
    }


    /**
     * Set the value of ManId
     *
     * @param v new value
     */
    public void setManId(int v) 
    {

        if (this.manId != v)
        {
            this.manId = v;
            setModified(true);
        }


    }

    /**
     * Get the ManName
     *
     * @return String
     */
    public String getManName()
    {
        return manName;
    }


    /**
     * Set the value of ManName
     *
     * @param v new value
     */
    public void setManName(String v) 
    {

        if (!ObjectUtils.equals(this.manName, v))
        {
            this.manName = v;
            setModified(true);
        }


    }

    /**
     * Get the UpdateTime
     *
     * @return Date
     */
    public Date getUpdateTime()
    {
        return updateTime;
    }


    /**
     * Set the value of UpdateTime
     *
     * @param v new value
     */
    public void setUpdateTime(Date v) 
    {

        if (!ObjectUtils.equals(this.updateTime, v))
        {
            this.updateTime = v;
            setModified(true);
        }


    }

       
        
    private static List fieldNames = null;

    /**
     * Generate a list of field names.
     *
     * @return a list of field names
     */
    public static synchronized List getFieldNames()
    {
        if (fieldNames == null)
        {
            fieldNames = new ArrayList();
            fieldNames.add("Id");
            fieldNames.add("KaopinId");
            fieldNames.add("SumScore");
            fieldNames.add("Anshi");
            fieldNames.add("Youyiyi");
            fieldNames.add("Neirong");
            fieldNames.add("Shouhuo");
            fieldNames.add("ShuohuaQingchu");
            fieldNames.add("HeibanziQingchu");
            fieldNames.add("HeibanziZhongyao");
            fieldNames.add("ShuliangHeshi");
            fieldNames.add("HanziJihui");
            fieldNames.add("HuodongYouxiao");
            fieldNames.add("ZuoyeHeshi");
            fieldNames.add("ZuoyeBangzhu");
            fieldNames.add("Naixin");
            fieldNames.add("Jinbu");
            fieldNames.add("Yange");
            fieldNames.add("Yuanyi");
            fieldNames.add("Liaotian");
            fieldNames.add("Pingjia");
            fieldNames.add("CreateTime");
            fieldNames.add("ManId");
            fieldNames.add("ManName");
            fieldNames.add("UpdateTime");
            fieldNames = Collections.unmodifiableList(fieldNames);
        }
        return fieldNames;
    }

    /**
     * Retrieves a field from the object by field (Java) name passed in as a String.
     *
     * @param name field name
     * @return value
     */
    public Object getByName(String name)
    {
        if (name.equals("Id"))
        {
            return new Integer(getId());
        }
        if (name.equals("KaopinId"))
        {
            return new Integer(getKaopinId());
        }
        if (name.equals("SumScore"))
        {
            return new Integer(getSumScore());
        }
        if (name.equals("Anshi"))
        {
            return new Integer(getAnshi());
        }
        if (name.equals("Youyiyi"))
        {
            return new Integer(getYouyiyi());
        }
        if (name.equals("Neirong"))
        {
            return new Integer(getNeirong());
        }
        if (name.equals("Shouhuo"))
        {
            return new Integer(getShouhuo());
        }
        if (name.equals("ShuohuaQingchu"))
        {
            return new Integer(getShuohuaQingchu());
        }
        if (name.equals("HeibanziQingchu"))
        {
            return new Integer(getHeibanziQingchu());
        }
        if (name.equals("HeibanziZhongyao"))
        {
            return new Integer(getHeibanziZhongyao());
        }
        if (name.equals("ShuliangHeshi"))
        {
            return new Integer(getShuliangHeshi());
        }
        if (name.equals("HanziJihui"))
        {
            return new Integer(getHanziJihui());
        }
        if (name.equals("HuodongYouxiao"))
        {
            return new Integer(getHuodongYouxiao());
        }
        if (name.equals("ZuoyeHeshi"))
        {
            return new Integer(getZuoyeHeshi());
        }
        if (name.equals("ZuoyeBangzhu"))
        {
            return new Integer(getZuoyeBangzhu());
        }
        if (name.equals("Naixin"))
        {
            return new Integer(getNaixin());
        }
        if (name.equals("Jinbu"))
        {
            return new Integer(getJinbu());
        }
        if (name.equals("Yange"))
        {
            return new Integer(getYange());
        }
        if (name.equals("Yuanyi"))
        {
            return new Integer(getYuanyi());
        }
        if (name.equals("Liaotian"))
        {
            return new Integer(getLiaotian());
        }
        if (name.equals("Pingjia"))
        {
            return getPingjia();
        }
        if (name.equals("CreateTime"))
        {
            return getCreateTime();
        }
        if (name.equals("ManId"))
        {
            return new Integer(getManId());
        }
        if (name.equals("ManName"))
        {
            return getManName();
        }
        if (name.equals("UpdateTime"))
        {
            return getUpdateTime();
        }
        return null;
    }

    /**
     * Set a field in the object by field (Java) name.
     *
     * @param name field name
     * @param value field value
     * @return True if value was set, false if not (invalid name / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByName(String name, Object value )
        throws TorqueException, IllegalArgumentException
    {
        if (name.equals("Id"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("KaopinId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setKaopinId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("SumScore"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setSumScore(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Anshi"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setAnshi(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Youyiyi"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setYouyiyi(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Neirong"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setNeirong(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Shouhuo"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setShouhuo(((Integer) value).intValue());
            return true;
        }
        if (name.equals("ShuohuaQingchu"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setShuohuaQingchu(((Integer) value).intValue());
            return true;
        }
        if (name.equals("HeibanziQingchu"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setHeibanziQingchu(((Integer) value).intValue());
            return true;
        }
        if (name.equals("HeibanziZhongyao"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setHeibanziZhongyao(((Integer) value).intValue());
            return true;
        }
        if (name.equals("ShuliangHeshi"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setShuliangHeshi(((Integer) value).intValue());
            return true;
        }
        if (name.equals("HanziJihui"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setHanziJihui(((Integer) value).intValue());
            return true;
        }
        if (name.equals("HuodongYouxiao"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setHuodongYouxiao(((Integer) value).intValue());
            return true;
        }
        if (name.equals("ZuoyeHeshi"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setZuoyeHeshi(((Integer) value).intValue());
            return true;
        }
        if (name.equals("ZuoyeBangzhu"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setZuoyeBangzhu(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Naixin"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setNaixin(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Jinbu"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setJinbu(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Yange"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setYange(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Yuanyi"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setYuanyi(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Liaotian"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setLiaotian(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Pingjia"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setPingjia((String) value);
            return true;
        }
        if (name.equals("CreateTime"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setCreateTime((Date) value);
            return true;
        }
        if (name.equals("ManId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setManId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("ManName"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setManName((String) value);
            return true;
        }
        if (name.equals("UpdateTime"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setUpdateTime((Date) value);
            return true;
        }
        return false;
    }

    /**
     * Retrieves a field from the object by name passed in
     * as a String.  The String must be one of the static
     * Strings defined in this Class' Peer.
     *
     * @param name peer name
     * @return value
     */
    public Object getByPeerName(String name)
    {
        if (name.equals(JiaoxueKaopinInfoPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(JiaoxueKaopinInfoPeer.KAOPIN_ID))
        {
            return new Integer(getKaopinId());
        }
        if (name.equals(JiaoxueKaopinInfoPeer.SUM_SCORE))
        {
            return new Integer(getSumScore());
        }
        if (name.equals(JiaoxueKaopinInfoPeer.ANSHI))
        {
            return new Integer(getAnshi());
        }
        if (name.equals(JiaoxueKaopinInfoPeer.YOUYIYI))
        {
            return new Integer(getYouyiyi());
        }
        if (name.equals(JiaoxueKaopinInfoPeer.NEIRONG))
        {
            return new Integer(getNeirong());
        }
        if (name.equals(JiaoxueKaopinInfoPeer.SHOUHUO))
        {
            return new Integer(getShouhuo());
        }
        if (name.equals(JiaoxueKaopinInfoPeer.SHUOHUA_QINGCHU))
        {
            return new Integer(getShuohuaQingchu());
        }
        if (name.equals(JiaoxueKaopinInfoPeer.HEIBANZI_QINGCHU))
        {
            return new Integer(getHeibanziQingchu());
        }
        if (name.equals(JiaoxueKaopinInfoPeer.HEIBANZI_ZHONGYAO))
        {
            return new Integer(getHeibanziZhongyao());
        }
        if (name.equals(JiaoxueKaopinInfoPeer.SHULIANG_HESHI))
        {
            return new Integer(getShuliangHeshi());
        }
        if (name.equals(JiaoxueKaopinInfoPeer.HANZI_JIHUI))
        {
            return new Integer(getHanziJihui());
        }
        if (name.equals(JiaoxueKaopinInfoPeer.HUODONG_YOUXIAO))
        {
            return new Integer(getHuodongYouxiao());
        }
        if (name.equals(JiaoxueKaopinInfoPeer.ZUOYE_HESHI))
        {
            return new Integer(getZuoyeHeshi());
        }
        if (name.equals(JiaoxueKaopinInfoPeer.ZUOYE_BANGZHU))
        {
            return new Integer(getZuoyeBangzhu());
        }
        if (name.equals(JiaoxueKaopinInfoPeer.NAIXIN))
        {
            return new Integer(getNaixin());
        }
        if (name.equals(JiaoxueKaopinInfoPeer.JINBU))
        {
            return new Integer(getJinbu());
        }
        if (name.equals(JiaoxueKaopinInfoPeer.YANGE))
        {
            return new Integer(getYange());
        }
        if (name.equals(JiaoxueKaopinInfoPeer.YUANYI))
        {
            return new Integer(getYuanyi());
        }
        if (name.equals(JiaoxueKaopinInfoPeer.LIAOTIAN))
        {
            return new Integer(getLiaotian());
        }
        if (name.equals(JiaoxueKaopinInfoPeer.PINGJIA))
        {
            return getPingjia();
        }
        if (name.equals(JiaoxueKaopinInfoPeer.CREATE_TIME))
        {
            return getCreateTime();
        }
        if (name.equals(JiaoxueKaopinInfoPeer.MAN_ID))
        {
            return new Integer(getManId());
        }
        if (name.equals(JiaoxueKaopinInfoPeer.MAN_NAME))
        {
            return getManName();
        }
        if (name.equals(JiaoxueKaopinInfoPeer.UPDATE_TIME))
        {
            return getUpdateTime();
        }
        return null;
    }

    /**
     * Set field values by Peer Field Name
     *
     * @param name field name
     * @param value field value
     * @return True if value was set, false if not (invalid name / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByPeerName(String name, Object value)
        throws TorqueException, IllegalArgumentException
    {
      if (JiaoxueKaopinInfoPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (JiaoxueKaopinInfoPeer.KAOPIN_ID.equals(name))
        {
            return setByName("KaopinId", value);
        }
      if (JiaoxueKaopinInfoPeer.SUM_SCORE.equals(name))
        {
            return setByName("SumScore", value);
        }
      if (JiaoxueKaopinInfoPeer.ANSHI.equals(name))
        {
            return setByName("Anshi", value);
        }
      if (JiaoxueKaopinInfoPeer.YOUYIYI.equals(name))
        {
            return setByName("Youyiyi", value);
        }
      if (JiaoxueKaopinInfoPeer.NEIRONG.equals(name))
        {
            return setByName("Neirong", value);
        }
      if (JiaoxueKaopinInfoPeer.SHOUHUO.equals(name))
        {
            return setByName("Shouhuo", value);
        }
      if (JiaoxueKaopinInfoPeer.SHUOHUA_QINGCHU.equals(name))
        {
            return setByName("ShuohuaQingchu", value);
        }
      if (JiaoxueKaopinInfoPeer.HEIBANZI_QINGCHU.equals(name))
        {
            return setByName("HeibanziQingchu", value);
        }
      if (JiaoxueKaopinInfoPeer.HEIBANZI_ZHONGYAO.equals(name))
        {
            return setByName("HeibanziZhongyao", value);
        }
      if (JiaoxueKaopinInfoPeer.SHULIANG_HESHI.equals(name))
        {
            return setByName("ShuliangHeshi", value);
        }
      if (JiaoxueKaopinInfoPeer.HANZI_JIHUI.equals(name))
        {
            return setByName("HanziJihui", value);
        }
      if (JiaoxueKaopinInfoPeer.HUODONG_YOUXIAO.equals(name))
        {
            return setByName("HuodongYouxiao", value);
        }
      if (JiaoxueKaopinInfoPeer.ZUOYE_HESHI.equals(name))
        {
            return setByName("ZuoyeHeshi", value);
        }
      if (JiaoxueKaopinInfoPeer.ZUOYE_BANGZHU.equals(name))
        {
            return setByName("ZuoyeBangzhu", value);
        }
      if (JiaoxueKaopinInfoPeer.NAIXIN.equals(name))
        {
            return setByName("Naixin", value);
        }
      if (JiaoxueKaopinInfoPeer.JINBU.equals(name))
        {
            return setByName("Jinbu", value);
        }
      if (JiaoxueKaopinInfoPeer.YANGE.equals(name))
        {
            return setByName("Yange", value);
        }
      if (JiaoxueKaopinInfoPeer.YUANYI.equals(name))
        {
            return setByName("Yuanyi", value);
        }
      if (JiaoxueKaopinInfoPeer.LIAOTIAN.equals(name))
        {
            return setByName("Liaotian", value);
        }
      if (JiaoxueKaopinInfoPeer.PINGJIA.equals(name))
        {
            return setByName("Pingjia", value);
        }
      if (JiaoxueKaopinInfoPeer.CREATE_TIME.equals(name))
        {
            return setByName("CreateTime", value);
        }
      if (JiaoxueKaopinInfoPeer.MAN_ID.equals(name))
        {
            return setByName("ManId", value);
        }
      if (JiaoxueKaopinInfoPeer.MAN_NAME.equals(name))
        {
            return setByName("ManName", value);
        }
      if (JiaoxueKaopinInfoPeer.UPDATE_TIME.equals(name))
        {
            return setByName("UpdateTime", value);
        }
        return false;
    }

    /**
     * Retrieves a field from the object by Position as specified
     * in the xml schema.  Zero-based.
     *
     * @param pos position in xml schema
     * @return value
     */
    public Object getByPosition(int pos)
    {
        if (pos == 0)
        {
            return new Integer(getId());
        }
        if (pos == 1)
        {
            return new Integer(getKaopinId());
        }
        if (pos == 2)
        {
            return new Integer(getSumScore());
        }
        if (pos == 3)
        {
            return new Integer(getAnshi());
        }
        if (pos == 4)
        {
            return new Integer(getYouyiyi());
        }
        if (pos == 5)
        {
            return new Integer(getNeirong());
        }
        if (pos == 6)
        {
            return new Integer(getShouhuo());
        }
        if (pos == 7)
        {
            return new Integer(getShuohuaQingchu());
        }
        if (pos == 8)
        {
            return new Integer(getHeibanziQingchu());
        }
        if (pos == 9)
        {
            return new Integer(getHeibanziZhongyao());
        }
        if (pos == 10)
        {
            return new Integer(getShuliangHeshi());
        }
        if (pos == 11)
        {
            return new Integer(getHanziJihui());
        }
        if (pos == 12)
        {
            return new Integer(getHuodongYouxiao());
        }
        if (pos == 13)
        {
            return new Integer(getZuoyeHeshi());
        }
        if (pos == 14)
        {
            return new Integer(getZuoyeBangzhu());
        }
        if (pos == 15)
        {
            return new Integer(getNaixin());
        }
        if (pos == 16)
        {
            return new Integer(getJinbu());
        }
        if (pos == 17)
        {
            return new Integer(getYange());
        }
        if (pos == 18)
        {
            return new Integer(getYuanyi());
        }
        if (pos == 19)
        {
            return new Integer(getLiaotian());
        }
        if (pos == 20)
        {
            return getPingjia();
        }
        if (pos == 21)
        {
            return getCreateTime();
        }
        if (pos == 22)
        {
            return new Integer(getManId());
        }
        if (pos == 23)
        {
            return getManName();
        }
        if (pos == 24)
        {
            return getUpdateTime();
        }
        return null;
    }

    /**
     * Set field values by its position (zero based) in the XML schema.
     *
     * @param position The field position
     * @param value field value
     * @return True if value was set, false if not (invalid position / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByPosition(int position, Object value)
        throws TorqueException, IllegalArgumentException
    {
    if (position == 0)
        {
            return setByName("Id", value);
        }
    if (position == 1)
        {
            return setByName("KaopinId", value);
        }
    if (position == 2)
        {
            return setByName("SumScore", value);
        }
    if (position == 3)
        {
            return setByName("Anshi", value);
        }
    if (position == 4)
        {
            return setByName("Youyiyi", value);
        }
    if (position == 5)
        {
            return setByName("Neirong", value);
        }
    if (position == 6)
        {
            return setByName("Shouhuo", value);
        }
    if (position == 7)
        {
            return setByName("ShuohuaQingchu", value);
        }
    if (position == 8)
        {
            return setByName("HeibanziQingchu", value);
        }
    if (position == 9)
        {
            return setByName("HeibanziZhongyao", value);
        }
    if (position == 10)
        {
            return setByName("ShuliangHeshi", value);
        }
    if (position == 11)
        {
            return setByName("HanziJihui", value);
        }
    if (position == 12)
        {
            return setByName("HuodongYouxiao", value);
        }
    if (position == 13)
        {
            return setByName("ZuoyeHeshi", value);
        }
    if (position == 14)
        {
            return setByName("ZuoyeBangzhu", value);
        }
    if (position == 15)
        {
            return setByName("Naixin", value);
        }
    if (position == 16)
        {
            return setByName("Jinbu", value);
        }
    if (position == 17)
        {
            return setByName("Yange", value);
        }
    if (position == 18)
        {
            return setByName("Yuanyi", value);
        }
    if (position == 19)
        {
            return setByName("Liaotian", value);
        }
    if (position == 20)
        {
            return setByName("Pingjia", value);
        }
    if (position == 21)
        {
            return setByName("CreateTime", value);
        }
    if (position == 22)
        {
            return setByName("ManId", value);
        }
    if (position == 23)
        {
            return setByName("ManName", value);
        }
    if (position == 24)
        {
            return setByName("UpdateTime", value);
        }
        return false;
    }
     
    /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.
     *
     * @throws Exception
     */
    public void save() throws Exception
    {
        save(JiaoxueKaopinInfoPeer.DATABASE_NAME);
    }

    /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.
     * Note: this code is here because the method body is
     * auto-generated conditionally and therefore needs to be
     * in this file instead of in the super class, BaseObject.
     *
     * @param dbName
     * @throws TorqueException
     */
    public void save(String dbName) throws TorqueException
    {
        Connection con = null;
        try
        {
            con = Transaction.begin(dbName);
            save(con);
            Transaction.commit(con);
        }
        catch(TorqueException e)
        {
            Transaction.safeRollback(con);
            throw e;
        }
    }

    /** flag to prevent endless save loop, if this object is referenced
        by another object which falls in this transaction. */
    private boolean alreadyInSave = false;
    /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.  This method
     * is meant to be used as part of a transaction, otherwise use
     * the save() method and the connection details will be handled
     * internally
     *
     * @param con
     * @throws TorqueException
     */
    public void save(Connection con) throws TorqueException
    {
        if (!alreadyInSave)
        {
            alreadyInSave = true;



            // If this object has been modified, then save it to the database.
            if (isModified())
            {
                if (isNew())
                {
                    JiaoxueKaopinInfoPeer.doInsert((JiaoxueKaopinInfo) this, con);
                    setNew(false);
                }
                else
                {
                    JiaoxueKaopinInfoPeer.doUpdate((JiaoxueKaopinInfo) this, con);
                }
            }

            alreadyInSave = false;
        }
    }


    /**
     * Set the PrimaryKey using ObjectKey.
     *
     * @param key id ObjectKey
     */
    public void setPrimaryKey(ObjectKey key)
        
    {
        setId(((NumberKey) key).intValue());
    }

    /**
     * Set the PrimaryKey using a String.
     *
     * @param key
     */
    public void setPrimaryKey(String key) 
    {
        setId(Integer.parseInt(key));
    }


    /**
     * returns an id that differentiates this object from others
     * of its class.
     */
    public ObjectKey getPrimaryKey()
    {
        return SimpleKey.keyFor(getId());
    }
 

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
     * It then fills all the association collections and sets the
     * related objects to isNew=true.
     */
    public JiaoxueKaopinInfo copy() throws TorqueException
    {
        return copy(true);
    }

    /**
     * Makes a copy of this object using connection.
     * It creates a new object filling in the simple attributes.
     * It then fills all the association collections and sets the
     * related objects to isNew=true.
     *
     * @param con the database connection to read associated objects.
     */
    public JiaoxueKaopinInfo copy(Connection con) throws TorqueException
    {
        return copy(true, con);
    }

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
     * If the parameter deepcopy is true, it then fills all the
     * association collections and sets the related objects to
     * isNew=true.
     *
     * @param deepcopy whether to copy the associated objects.
     */
    public JiaoxueKaopinInfo copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new JiaoxueKaopinInfo(), deepcopy);
    }

    /**
     * Makes a copy of this object using connection.
     * It creates a new object filling in the simple attributes.
     * If the parameter deepcopy is true, it then fills all the
     * association collections and sets the related objects to
     * isNew=true.
     *
     * @param deepcopy whether to copy the associated objects.
     * @param con the database connection to read associated objects.
     */
    public JiaoxueKaopinInfo copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new JiaoxueKaopinInfo(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected JiaoxueKaopinInfo copyInto(JiaoxueKaopinInfo copyObj) throws TorqueException
    {
        return copyInto(copyObj, true);
    }

  
    /**
     * Fills the copyObj with the contents of this object using connection.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param con the database connection to read associated objects.
     */
    protected JiaoxueKaopinInfo copyInto(JiaoxueKaopinInfo copyObj, Connection con) throws TorqueException
    {
        return copyInto(copyObj, true, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * If deepcopy is true, The associated objects are also copied
     * and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param deepcopy whether the associated objects should be copied.
     */
    protected JiaoxueKaopinInfo copyInto(JiaoxueKaopinInfo copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setKaopinId(kaopinId);
        copyObj.setSumScore(sumScore);
        copyObj.setAnshi(anshi);
        copyObj.setYouyiyi(youyiyi);
        copyObj.setNeirong(neirong);
        copyObj.setShouhuo(shouhuo);
        copyObj.setShuohuaQingchu(shuohuaQingchu);
        copyObj.setHeibanziQingchu(heibanziQingchu);
        copyObj.setHeibanziZhongyao(heibanziZhongyao);
        copyObj.setShuliangHeshi(shuliangHeshi);
        copyObj.setHanziJihui(hanziJihui);
        copyObj.setHuodongYouxiao(huodongYouxiao);
        copyObj.setZuoyeHeshi(zuoyeHeshi);
        copyObj.setZuoyeBangzhu(zuoyeBangzhu);
        copyObj.setNaixin(naixin);
        copyObj.setJinbu(jinbu);
        copyObj.setYange(yange);
        copyObj.setYuanyi(yuanyi);
        copyObj.setLiaotian(liaotian);
        copyObj.setPingjia(pingjia);
        copyObj.setCreateTime(createTime);
        copyObj.setManId(manId);
        copyObj.setManName(manName);
        copyObj.setUpdateTime(updateTime);

        copyObj.setId( 0);

        if (deepcopy)
        {
        }
        return copyObj;
    }
        
    
    /**
     * Fills the copyObj with the contents of this object using connection.
     * If deepcopy is true, The associated objects are also copied
     * and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param deepcopy whether the associated objects should be copied.
     * @param con the database connection to read associated objects.
     */
    protected JiaoxueKaopinInfo copyInto(JiaoxueKaopinInfo copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setKaopinId(kaopinId);
        copyObj.setSumScore(sumScore);
        copyObj.setAnshi(anshi);
        copyObj.setYouyiyi(youyiyi);
        copyObj.setNeirong(neirong);
        copyObj.setShouhuo(shouhuo);
        copyObj.setShuohuaQingchu(shuohuaQingchu);
        copyObj.setHeibanziQingchu(heibanziQingchu);
        copyObj.setHeibanziZhongyao(heibanziZhongyao);
        copyObj.setShuliangHeshi(shuliangHeshi);
        copyObj.setHanziJihui(hanziJihui);
        copyObj.setHuodongYouxiao(huodongYouxiao);
        copyObj.setZuoyeHeshi(zuoyeHeshi);
        copyObj.setZuoyeBangzhu(zuoyeBangzhu);
        copyObj.setNaixin(naixin);
        copyObj.setJinbu(jinbu);
        copyObj.setYange(yange);
        copyObj.setYuanyi(yuanyi);
        copyObj.setLiaotian(liaotian);
        copyObj.setPingjia(pingjia);
        copyObj.setCreateTime(createTime);
        copyObj.setManId(manId);
        copyObj.setManName(manName);
        copyObj.setUpdateTime(updateTime);

        copyObj.setId( 0);

        if (deepcopy)
        {
        }
        return copyObj;
    }
    
    

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public JiaoxueKaopinInfoPeer getPeer()
    {
        return peer;
    }

    /**
     * Retrieves the TableMap object related to this Table data without
     * compiler warnings of using getPeer().getTableMap().
     *
     * @return The associated TableMap object.
     */
    public TableMap getTableMap() throws TorqueException
    {
        return JiaoxueKaopinInfoPeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("JiaoxueKaopinInfo:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("KaopinId = ")
           .append(getKaopinId())
           .append("\n");
        str.append("SumScore = ")
           .append(getSumScore())
           .append("\n");
        str.append("Anshi = ")
           .append(getAnshi())
           .append("\n");
        str.append("Youyiyi = ")
           .append(getYouyiyi())
           .append("\n");
        str.append("Neirong = ")
           .append(getNeirong())
           .append("\n");
        str.append("Shouhuo = ")
           .append(getShouhuo())
           .append("\n");
        str.append("ShuohuaQingchu = ")
           .append(getShuohuaQingchu())
           .append("\n");
        str.append("HeibanziQingchu = ")
           .append(getHeibanziQingchu())
           .append("\n");
        str.append("HeibanziZhongyao = ")
           .append(getHeibanziZhongyao())
           .append("\n");
        str.append("ShuliangHeshi = ")
           .append(getShuliangHeshi())
           .append("\n");
        str.append("HanziJihui = ")
           .append(getHanziJihui())
           .append("\n");
        str.append("HuodongYouxiao = ")
           .append(getHuodongYouxiao())
           .append("\n");
        str.append("ZuoyeHeshi = ")
           .append(getZuoyeHeshi())
           .append("\n");
        str.append("ZuoyeBangzhu = ")
           .append(getZuoyeBangzhu())
           .append("\n");
        str.append("Naixin = ")
           .append(getNaixin())
           .append("\n");
        str.append("Jinbu = ")
           .append(getJinbu())
           .append("\n");
        str.append("Yange = ")
           .append(getYange())
           .append("\n");
        str.append("Yuanyi = ")
           .append(getYuanyi())
           .append("\n");
        str.append("Liaotian = ")
           .append(getLiaotian())
           .append("\n");
        str.append("Pingjia = ")
           .append(getPingjia())
           .append("\n");
        str.append("CreateTime = ")
           .append(getCreateTime())
           .append("\n");
        str.append("ManId = ")
           .append(getManId())
           .append("\n");
        str.append("ManName = ")
           .append(getManName())
           .append("\n");
        str.append("UpdateTime = ")
           .append(getUpdateTime())
           .append("\n");
        return(str.toString());
    }
}
