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
 * extended all references should be to WaipinTeacherJixiao
 */
public abstract class BaseWaipinTeacherJixiao extends BaseObject
{
    /** The Peer class */
    private static final WaipinTeacherJixiaoPeer peer =
        new WaipinTeacherJixiaoPeer();


    /** The value for the id field */
    private int id;

    /** The value for the youxiu field */
    private int youxiu = 0;

    /** The value for the xueqiId field */
    private int xueqiId = 0;

    /** The value for the banjiId field */
    private int banjiId = 0;

    /** The value for the kechengId field */
    private int kechengId = 0;

    /** The value for the teacherId field */
    private int teacherId = 0;

    /** The value for the teacherName field */
    private String teacherName;

    /** The value for the scKaopin field */
    private double scKaopin = 0;

    /** The value for the scChuqin field */
    private double scChuqin = 0;

    /** The value for the scJiaoxuefile field */
    private double scJiaoxuefile = 0;

    /** The value for the scTingke field */
    private double scTingke = 0;

    /** The value for the scKaihui field */
    private double scKaihui = 0;

    /** The value for the scKaihuiReason field */
    private String scKaihuiReason;

    /** The value for the scHuodong field */
    private double scHuodong = 0;

    /** The value for the scHuodongReason field */
    private String scHuodongReason;

    /** The value for the scYinxiang field */
    private double scYinxiang = 0;

    /** The value for the scYinxiangReason field */
    private String scYinxiangReason;

    /** The value for the scGongxian field */
    private double scGongxian = 0;

    /** The value for the scGongxianReason field */
    private String scGongxianReason;

    /** The value for the remark field */
    private String remark;

    /** The value for the memberId field */
    private int memberId;

    /** The value for the memberName field */
    private String memberName;

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
     * Get the Youxiu
     *
     * @return int
     */
    public int getYouxiu()
    {
        return youxiu;
    }


    /**
     * Set the value of Youxiu
     *
     * @param v new value
     */
    public void setYouxiu(int v) 
    {

        if (this.youxiu != v)
        {
            this.youxiu = v;
            setModified(true);
        }


    }

    /**
     * Get the XueqiId
     *
     * @return int
     */
    public int getXueqiId()
    {
        return xueqiId;
    }


    /**
     * Set the value of XueqiId
     *
     * @param v new value
     */
    public void setXueqiId(int v) 
    {

        if (this.xueqiId != v)
        {
            this.xueqiId = v;
            setModified(true);
        }


    }

    /**
     * Get the BanjiId
     *
     * @return int
     */
    public int getBanjiId()
    {
        return banjiId;
    }


    /**
     * Set the value of BanjiId
     *
     * @param v new value
     */
    public void setBanjiId(int v) 
    {

        if (this.banjiId != v)
        {
            this.banjiId = v;
            setModified(true);
        }


    }

    /**
     * Get the KechengId
     *
     * @return int
     */
    public int getKechengId()
    {
        return kechengId;
    }


    /**
     * Set the value of KechengId
     *
     * @param v new value
     */
    public void setKechengId(int v) 
    {

        if (this.kechengId != v)
        {
            this.kechengId = v;
            setModified(true);
        }


    }

    /**
     * Get the TeacherId
     *
     * @return int
     */
    public int getTeacherId()
    {
        return teacherId;
    }


    /**
     * Set the value of TeacherId
     *
     * @param v new value
     */
    public void setTeacherId(int v) 
    {

        if (this.teacherId != v)
        {
            this.teacherId = v;
            setModified(true);
        }


    }

    /**
     * Get the TeacherName
     *
     * @return String
     */
    public String getTeacherName()
    {
        return teacherName;
    }


    /**
     * Set the value of TeacherName
     *
     * @param v new value
     */
    public void setTeacherName(String v) 
    {

        if (!ObjectUtils.equals(this.teacherName, v))
        {
            this.teacherName = v;
            setModified(true);
        }


    }

    /**
     * Get the ScKaopin
     *
     * @return double
     */
    public double getScKaopin()
    {
        return scKaopin;
    }


    /**
     * Set the value of ScKaopin
     *
     * @param v new value
     */
    public void setScKaopin(double v) 
    {

        if (this.scKaopin != v)
        {
            this.scKaopin = v;
            setModified(true);
        }


    }

    /**
     * Get the ScChuqin
     *
     * @return double
     */
    public double getScChuqin()
    {
        return scChuqin;
    }


    /**
     * Set the value of ScChuqin
     *
     * @param v new value
     */
    public void setScChuqin(double v) 
    {

        if (this.scChuqin != v)
        {
            this.scChuqin = v;
            setModified(true);
        }


    }

    /**
     * Get the ScJiaoxuefile
     *
     * @return double
     */
    public double getScJiaoxuefile()
    {
        return scJiaoxuefile;
    }


    /**
     * Set the value of ScJiaoxuefile
     *
     * @param v new value
     */
    public void setScJiaoxuefile(double v) 
    {

        if (this.scJiaoxuefile != v)
        {
            this.scJiaoxuefile = v;
            setModified(true);
        }


    }

    /**
     * Get the ScTingke
     *
     * @return double
     */
    public double getScTingke()
    {
        return scTingke;
    }


    /**
     * Set the value of ScTingke
     *
     * @param v new value
     */
    public void setScTingke(double v) 
    {

        if (this.scTingke != v)
        {
            this.scTingke = v;
            setModified(true);
        }


    }

    /**
     * Get the ScKaihui
     *
     * @return double
     */
    public double getScKaihui()
    {
        return scKaihui;
    }


    /**
     * Set the value of ScKaihui
     *
     * @param v new value
     */
    public void setScKaihui(double v) 
    {

        if (this.scKaihui != v)
        {
            this.scKaihui = v;
            setModified(true);
        }


    }

    /**
     * Get the ScKaihuiReason
     *
     * @return String
     */
    public String getScKaihuiReason()
    {
        return scKaihuiReason;
    }


    /**
     * Set the value of ScKaihuiReason
     *
     * @param v new value
     */
    public void setScKaihuiReason(String v) 
    {

        if (!ObjectUtils.equals(this.scKaihuiReason, v))
        {
            this.scKaihuiReason = v;
            setModified(true);
        }


    }

    /**
     * Get the ScHuodong
     *
     * @return double
     */
    public double getScHuodong()
    {
        return scHuodong;
    }


    /**
     * Set the value of ScHuodong
     *
     * @param v new value
     */
    public void setScHuodong(double v) 
    {

        if (this.scHuodong != v)
        {
            this.scHuodong = v;
            setModified(true);
        }


    }

    /**
     * Get the ScHuodongReason
     *
     * @return String
     */
    public String getScHuodongReason()
    {
        return scHuodongReason;
    }


    /**
     * Set the value of ScHuodongReason
     *
     * @param v new value
     */
    public void setScHuodongReason(String v) 
    {

        if (!ObjectUtils.equals(this.scHuodongReason, v))
        {
            this.scHuodongReason = v;
            setModified(true);
        }


    }

    /**
     * Get the ScYinxiang
     *
     * @return double
     */
    public double getScYinxiang()
    {
        return scYinxiang;
    }


    /**
     * Set the value of ScYinxiang
     *
     * @param v new value
     */
    public void setScYinxiang(double v) 
    {

        if (this.scYinxiang != v)
        {
            this.scYinxiang = v;
            setModified(true);
        }


    }

    /**
     * Get the ScYinxiangReason
     *
     * @return String
     */
    public String getScYinxiangReason()
    {
        return scYinxiangReason;
    }


    /**
     * Set the value of ScYinxiangReason
     *
     * @param v new value
     */
    public void setScYinxiangReason(String v) 
    {

        if (!ObjectUtils.equals(this.scYinxiangReason, v))
        {
            this.scYinxiangReason = v;
            setModified(true);
        }


    }

    /**
     * Get the ScGongxian
     *
     * @return double
     */
    public double getScGongxian()
    {
        return scGongxian;
    }


    /**
     * Set the value of ScGongxian
     *
     * @param v new value
     */
    public void setScGongxian(double v) 
    {

        if (this.scGongxian != v)
        {
            this.scGongxian = v;
            setModified(true);
        }


    }

    /**
     * Get the ScGongxianReason
     *
     * @return String
     */
    public String getScGongxianReason()
    {
        return scGongxianReason;
    }


    /**
     * Set the value of ScGongxianReason
     *
     * @param v new value
     */
    public void setScGongxianReason(String v) 
    {

        if (!ObjectUtils.equals(this.scGongxianReason, v))
        {
            this.scGongxianReason = v;
            setModified(true);
        }


    }

    /**
     * Get the Remark
     *
     * @return String
     */
    public String getRemark()
    {
        return remark;
    }


    /**
     * Set the value of Remark
     *
     * @param v new value
     */
    public void setRemark(String v) 
    {

        if (!ObjectUtils.equals(this.remark, v))
        {
            this.remark = v;
            setModified(true);
        }


    }

    /**
     * Get the MemberId
     *
     * @return int
     */
    public int getMemberId()
    {
        return memberId;
    }


    /**
     * Set the value of MemberId
     *
     * @param v new value
     */
    public void setMemberId(int v) 
    {

        if (this.memberId != v)
        {
            this.memberId = v;
            setModified(true);
        }


    }

    /**
     * Get the MemberName
     *
     * @return String
     */
    public String getMemberName()
    {
        return memberName;
    }


    /**
     * Set the value of MemberName
     *
     * @param v new value
     */
    public void setMemberName(String v) 
    {

        if (!ObjectUtils.equals(this.memberName, v))
        {
            this.memberName = v;
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
            fieldNames.add("Youxiu");
            fieldNames.add("XueqiId");
            fieldNames.add("BanjiId");
            fieldNames.add("KechengId");
            fieldNames.add("TeacherId");
            fieldNames.add("TeacherName");
            fieldNames.add("ScKaopin");
            fieldNames.add("ScChuqin");
            fieldNames.add("ScJiaoxuefile");
            fieldNames.add("ScTingke");
            fieldNames.add("ScKaihui");
            fieldNames.add("ScKaihuiReason");
            fieldNames.add("ScHuodong");
            fieldNames.add("ScHuodongReason");
            fieldNames.add("ScYinxiang");
            fieldNames.add("ScYinxiangReason");
            fieldNames.add("ScGongxian");
            fieldNames.add("ScGongxianReason");
            fieldNames.add("Remark");
            fieldNames.add("MemberId");
            fieldNames.add("MemberName");
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
        if (name.equals("Youxiu"))
        {
            return new Integer(getYouxiu());
        }
        if (name.equals("XueqiId"))
        {
            return new Integer(getXueqiId());
        }
        if (name.equals("BanjiId"))
        {
            return new Integer(getBanjiId());
        }
        if (name.equals("KechengId"))
        {
            return new Integer(getKechengId());
        }
        if (name.equals("TeacherId"))
        {
            return new Integer(getTeacherId());
        }
        if (name.equals("TeacherName"))
        {
            return getTeacherName();
        }
        if (name.equals("ScKaopin"))
        {
            return new Double(getScKaopin());
        }
        if (name.equals("ScChuqin"))
        {
            return new Double(getScChuqin());
        }
        if (name.equals("ScJiaoxuefile"))
        {
            return new Double(getScJiaoxuefile());
        }
        if (name.equals("ScTingke"))
        {
            return new Double(getScTingke());
        }
        if (name.equals("ScKaihui"))
        {
            return new Double(getScKaihui());
        }
        if (name.equals("ScKaihuiReason"))
        {
            return getScKaihuiReason();
        }
        if (name.equals("ScHuodong"))
        {
            return new Double(getScHuodong());
        }
        if (name.equals("ScHuodongReason"))
        {
            return getScHuodongReason();
        }
        if (name.equals("ScYinxiang"))
        {
            return new Double(getScYinxiang());
        }
        if (name.equals("ScYinxiangReason"))
        {
            return getScYinxiangReason();
        }
        if (name.equals("ScGongxian"))
        {
            return new Double(getScGongxian());
        }
        if (name.equals("ScGongxianReason"))
        {
            return getScGongxianReason();
        }
        if (name.equals("Remark"))
        {
            return getRemark();
        }
        if (name.equals("MemberId"))
        {
            return new Integer(getMemberId());
        }
        if (name.equals("MemberName"))
        {
            return getMemberName();
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
        if (name.equals("Youxiu"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setYouxiu(((Integer) value).intValue());
            return true;
        }
        if (name.equals("XueqiId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setXueqiId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("BanjiId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setBanjiId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("KechengId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setKechengId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("TeacherId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setTeacherId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("TeacherName"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setTeacherName((String) value);
            return true;
        }
        if (name.equals("ScKaopin"))
        {
            if (value == null || ! (Double.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Double object.");
            }
            setScKaopin(((Double) value).doubleValue());
            return true;
        }
        if (name.equals("ScChuqin"))
        {
            if (value == null || ! (Double.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Double object.");
            }
            setScChuqin(((Double) value).doubleValue());
            return true;
        }
        if (name.equals("ScJiaoxuefile"))
        {
            if (value == null || ! (Double.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Double object.");
            }
            setScJiaoxuefile(((Double) value).doubleValue());
            return true;
        }
        if (name.equals("ScTingke"))
        {
            if (value == null || ! (Double.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Double object.");
            }
            setScTingke(((Double) value).doubleValue());
            return true;
        }
        if (name.equals("ScKaihui"))
        {
            if (value == null || ! (Double.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Double object.");
            }
            setScKaihui(((Double) value).doubleValue());
            return true;
        }
        if (name.equals("ScKaihuiReason"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setScKaihuiReason((String) value);
            return true;
        }
        if (name.equals("ScHuodong"))
        {
            if (value == null || ! (Double.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Double object.");
            }
            setScHuodong(((Double) value).doubleValue());
            return true;
        }
        if (name.equals("ScHuodongReason"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setScHuodongReason((String) value);
            return true;
        }
        if (name.equals("ScYinxiang"))
        {
            if (value == null || ! (Double.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Double object.");
            }
            setScYinxiang(((Double) value).doubleValue());
            return true;
        }
        if (name.equals("ScYinxiangReason"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setScYinxiangReason((String) value);
            return true;
        }
        if (name.equals("ScGongxian"))
        {
            if (value == null || ! (Double.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Double object.");
            }
            setScGongxian(((Double) value).doubleValue());
            return true;
        }
        if (name.equals("ScGongxianReason"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setScGongxianReason((String) value);
            return true;
        }
        if (name.equals("Remark"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setRemark((String) value);
            return true;
        }
        if (name.equals("MemberId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setMemberId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("MemberName"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setMemberName((String) value);
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
        if (name.equals(WaipinTeacherJixiaoPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(WaipinTeacherJixiaoPeer.YOUXIU))
        {
            return new Integer(getYouxiu());
        }
        if (name.equals(WaipinTeacherJixiaoPeer.XUEQI_ID))
        {
            return new Integer(getXueqiId());
        }
        if (name.equals(WaipinTeacherJixiaoPeer.BANJI_ID))
        {
            return new Integer(getBanjiId());
        }
        if (name.equals(WaipinTeacherJixiaoPeer.KECHENG_ID))
        {
            return new Integer(getKechengId());
        }
        if (name.equals(WaipinTeacherJixiaoPeer.TEACHER_ID))
        {
            return new Integer(getTeacherId());
        }
        if (name.equals(WaipinTeacherJixiaoPeer.TEACHER_NAME))
        {
            return getTeacherName();
        }
        if (name.equals(WaipinTeacherJixiaoPeer.SC_KAOPIN))
        {
            return new Double(getScKaopin());
        }
        if (name.equals(WaipinTeacherJixiaoPeer.SC_CHUQIN))
        {
            return new Double(getScChuqin());
        }
        if (name.equals(WaipinTeacherJixiaoPeer.SC_JIAOXUEFILE))
        {
            return new Double(getScJiaoxuefile());
        }
        if (name.equals(WaipinTeacherJixiaoPeer.SC_TINGKE))
        {
            return new Double(getScTingke());
        }
        if (name.equals(WaipinTeacherJixiaoPeer.SC_KAIHUI))
        {
            return new Double(getScKaihui());
        }
        if (name.equals(WaipinTeacherJixiaoPeer.SC_KAIHUI_REASON))
        {
            return getScKaihuiReason();
        }
        if (name.equals(WaipinTeacherJixiaoPeer.SC_HUODONG))
        {
            return new Double(getScHuodong());
        }
        if (name.equals(WaipinTeacherJixiaoPeer.SC_HUODONG_REASON))
        {
            return getScHuodongReason();
        }
        if (name.equals(WaipinTeacherJixiaoPeer.SC_YINXIANG))
        {
            return new Double(getScYinxiang());
        }
        if (name.equals(WaipinTeacherJixiaoPeer.SC_YINXIANG_REASON))
        {
            return getScYinxiangReason();
        }
        if (name.equals(WaipinTeacherJixiaoPeer.SC_GONGXIAN))
        {
            return new Double(getScGongxian());
        }
        if (name.equals(WaipinTeacherJixiaoPeer.SC_GONGXIAN_REASON))
        {
            return getScGongxianReason();
        }
        if (name.equals(WaipinTeacherJixiaoPeer.REMARK))
        {
            return getRemark();
        }
        if (name.equals(WaipinTeacherJixiaoPeer.MEMBER_ID))
        {
            return new Integer(getMemberId());
        }
        if (name.equals(WaipinTeacherJixiaoPeer.MEMBER_NAME))
        {
            return getMemberName();
        }
        if (name.equals(WaipinTeacherJixiaoPeer.UPDATE_TIME))
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
      if (WaipinTeacherJixiaoPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (WaipinTeacherJixiaoPeer.YOUXIU.equals(name))
        {
            return setByName("Youxiu", value);
        }
      if (WaipinTeacherJixiaoPeer.XUEQI_ID.equals(name))
        {
            return setByName("XueqiId", value);
        }
      if (WaipinTeacherJixiaoPeer.BANJI_ID.equals(name))
        {
            return setByName("BanjiId", value);
        }
      if (WaipinTeacherJixiaoPeer.KECHENG_ID.equals(name))
        {
            return setByName("KechengId", value);
        }
      if (WaipinTeacherJixiaoPeer.TEACHER_ID.equals(name))
        {
            return setByName("TeacherId", value);
        }
      if (WaipinTeacherJixiaoPeer.TEACHER_NAME.equals(name))
        {
            return setByName("TeacherName", value);
        }
      if (WaipinTeacherJixiaoPeer.SC_KAOPIN.equals(name))
        {
            return setByName("ScKaopin", value);
        }
      if (WaipinTeacherJixiaoPeer.SC_CHUQIN.equals(name))
        {
            return setByName("ScChuqin", value);
        }
      if (WaipinTeacherJixiaoPeer.SC_JIAOXUEFILE.equals(name))
        {
            return setByName("ScJiaoxuefile", value);
        }
      if (WaipinTeacherJixiaoPeer.SC_TINGKE.equals(name))
        {
            return setByName("ScTingke", value);
        }
      if (WaipinTeacherJixiaoPeer.SC_KAIHUI.equals(name))
        {
            return setByName("ScKaihui", value);
        }
      if (WaipinTeacherJixiaoPeer.SC_KAIHUI_REASON.equals(name))
        {
            return setByName("ScKaihuiReason", value);
        }
      if (WaipinTeacherJixiaoPeer.SC_HUODONG.equals(name))
        {
            return setByName("ScHuodong", value);
        }
      if (WaipinTeacherJixiaoPeer.SC_HUODONG_REASON.equals(name))
        {
            return setByName("ScHuodongReason", value);
        }
      if (WaipinTeacherJixiaoPeer.SC_YINXIANG.equals(name))
        {
            return setByName("ScYinxiang", value);
        }
      if (WaipinTeacherJixiaoPeer.SC_YINXIANG_REASON.equals(name))
        {
            return setByName("ScYinxiangReason", value);
        }
      if (WaipinTeacherJixiaoPeer.SC_GONGXIAN.equals(name))
        {
            return setByName("ScGongxian", value);
        }
      if (WaipinTeacherJixiaoPeer.SC_GONGXIAN_REASON.equals(name))
        {
            return setByName("ScGongxianReason", value);
        }
      if (WaipinTeacherJixiaoPeer.REMARK.equals(name))
        {
            return setByName("Remark", value);
        }
      if (WaipinTeacherJixiaoPeer.MEMBER_ID.equals(name))
        {
            return setByName("MemberId", value);
        }
      if (WaipinTeacherJixiaoPeer.MEMBER_NAME.equals(name))
        {
            return setByName("MemberName", value);
        }
      if (WaipinTeacherJixiaoPeer.UPDATE_TIME.equals(name))
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
            return new Integer(getYouxiu());
        }
        if (pos == 2)
        {
            return new Integer(getXueqiId());
        }
        if (pos == 3)
        {
            return new Integer(getBanjiId());
        }
        if (pos == 4)
        {
            return new Integer(getKechengId());
        }
        if (pos == 5)
        {
            return new Integer(getTeacherId());
        }
        if (pos == 6)
        {
            return getTeacherName();
        }
        if (pos == 7)
        {
            return new Double(getScKaopin());
        }
        if (pos == 8)
        {
            return new Double(getScChuqin());
        }
        if (pos == 9)
        {
            return new Double(getScJiaoxuefile());
        }
        if (pos == 10)
        {
            return new Double(getScTingke());
        }
        if (pos == 11)
        {
            return new Double(getScKaihui());
        }
        if (pos == 12)
        {
            return getScKaihuiReason();
        }
        if (pos == 13)
        {
            return new Double(getScHuodong());
        }
        if (pos == 14)
        {
            return getScHuodongReason();
        }
        if (pos == 15)
        {
            return new Double(getScYinxiang());
        }
        if (pos == 16)
        {
            return getScYinxiangReason();
        }
        if (pos == 17)
        {
            return new Double(getScGongxian());
        }
        if (pos == 18)
        {
            return getScGongxianReason();
        }
        if (pos == 19)
        {
            return getRemark();
        }
        if (pos == 20)
        {
            return new Integer(getMemberId());
        }
        if (pos == 21)
        {
            return getMemberName();
        }
        if (pos == 22)
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
            return setByName("Youxiu", value);
        }
    if (position == 2)
        {
            return setByName("XueqiId", value);
        }
    if (position == 3)
        {
            return setByName("BanjiId", value);
        }
    if (position == 4)
        {
            return setByName("KechengId", value);
        }
    if (position == 5)
        {
            return setByName("TeacherId", value);
        }
    if (position == 6)
        {
            return setByName("TeacherName", value);
        }
    if (position == 7)
        {
            return setByName("ScKaopin", value);
        }
    if (position == 8)
        {
            return setByName("ScChuqin", value);
        }
    if (position == 9)
        {
            return setByName("ScJiaoxuefile", value);
        }
    if (position == 10)
        {
            return setByName("ScTingke", value);
        }
    if (position == 11)
        {
            return setByName("ScKaihui", value);
        }
    if (position == 12)
        {
            return setByName("ScKaihuiReason", value);
        }
    if (position == 13)
        {
            return setByName("ScHuodong", value);
        }
    if (position == 14)
        {
            return setByName("ScHuodongReason", value);
        }
    if (position == 15)
        {
            return setByName("ScYinxiang", value);
        }
    if (position == 16)
        {
            return setByName("ScYinxiangReason", value);
        }
    if (position == 17)
        {
            return setByName("ScGongxian", value);
        }
    if (position == 18)
        {
            return setByName("ScGongxianReason", value);
        }
    if (position == 19)
        {
            return setByName("Remark", value);
        }
    if (position == 20)
        {
            return setByName("MemberId", value);
        }
    if (position == 21)
        {
            return setByName("MemberName", value);
        }
    if (position == 22)
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
        save(WaipinTeacherJixiaoPeer.DATABASE_NAME);
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
                    WaipinTeacherJixiaoPeer.doInsert((WaipinTeacherJixiao) this, con);
                    setNew(false);
                }
                else
                {
                    WaipinTeacherJixiaoPeer.doUpdate((WaipinTeacherJixiao) this, con);
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
    public WaipinTeacherJixiao copy() throws TorqueException
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
    public WaipinTeacherJixiao copy(Connection con) throws TorqueException
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
    public WaipinTeacherJixiao copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new WaipinTeacherJixiao(), deepcopy);
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
    public WaipinTeacherJixiao copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new WaipinTeacherJixiao(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected WaipinTeacherJixiao copyInto(WaipinTeacherJixiao copyObj) throws TorqueException
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
    protected WaipinTeacherJixiao copyInto(WaipinTeacherJixiao copyObj, Connection con) throws TorqueException
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
    protected WaipinTeacherJixiao copyInto(WaipinTeacherJixiao copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setYouxiu(youxiu);
        copyObj.setXueqiId(xueqiId);
        copyObj.setBanjiId(banjiId);
        copyObj.setKechengId(kechengId);
        copyObj.setTeacherId(teacherId);
        copyObj.setTeacherName(teacherName);
        copyObj.setScKaopin(scKaopin);
        copyObj.setScChuqin(scChuqin);
        copyObj.setScJiaoxuefile(scJiaoxuefile);
        copyObj.setScTingke(scTingke);
        copyObj.setScKaihui(scKaihui);
        copyObj.setScKaihuiReason(scKaihuiReason);
        copyObj.setScHuodong(scHuodong);
        copyObj.setScHuodongReason(scHuodongReason);
        copyObj.setScYinxiang(scYinxiang);
        copyObj.setScYinxiangReason(scYinxiangReason);
        copyObj.setScGongxian(scGongxian);
        copyObj.setScGongxianReason(scGongxianReason);
        copyObj.setRemark(remark);
        copyObj.setMemberId(memberId);
        copyObj.setMemberName(memberName);
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
    protected WaipinTeacherJixiao copyInto(WaipinTeacherJixiao copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setYouxiu(youxiu);
        copyObj.setXueqiId(xueqiId);
        copyObj.setBanjiId(banjiId);
        copyObj.setKechengId(kechengId);
        copyObj.setTeacherId(teacherId);
        copyObj.setTeacherName(teacherName);
        copyObj.setScKaopin(scKaopin);
        copyObj.setScChuqin(scChuqin);
        copyObj.setScJiaoxuefile(scJiaoxuefile);
        copyObj.setScTingke(scTingke);
        copyObj.setScKaihui(scKaihui);
        copyObj.setScKaihuiReason(scKaihuiReason);
        copyObj.setScHuodong(scHuodong);
        copyObj.setScHuodongReason(scHuodongReason);
        copyObj.setScYinxiang(scYinxiang);
        copyObj.setScYinxiangReason(scYinxiangReason);
        copyObj.setScGongxian(scGongxian);
        copyObj.setScGongxianReason(scGongxianReason);
        copyObj.setRemark(remark);
        copyObj.setMemberId(memberId);
        copyObj.setMemberName(memberName);
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
    public WaipinTeacherJixiaoPeer getPeer()
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
        return WaipinTeacherJixiaoPeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("WaipinTeacherJixiao:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("Youxiu = ")
           .append(getYouxiu())
           .append("\n");
        str.append("XueqiId = ")
           .append(getXueqiId())
           .append("\n");
        str.append("BanjiId = ")
           .append(getBanjiId())
           .append("\n");
        str.append("KechengId = ")
           .append(getKechengId())
           .append("\n");
        str.append("TeacherId = ")
           .append(getTeacherId())
           .append("\n");
        str.append("TeacherName = ")
           .append(getTeacherName())
           .append("\n");
        str.append("ScKaopin = ")
           .append(getScKaopin())
           .append("\n");
        str.append("ScChuqin = ")
           .append(getScChuqin())
           .append("\n");
        str.append("ScJiaoxuefile = ")
           .append(getScJiaoxuefile())
           .append("\n");
        str.append("ScTingke = ")
           .append(getScTingke())
           .append("\n");
        str.append("ScKaihui = ")
           .append(getScKaihui())
           .append("\n");
        str.append("ScKaihuiReason = ")
           .append(getScKaihuiReason())
           .append("\n");
        str.append("ScHuodong = ")
           .append(getScHuodong())
           .append("\n");
        str.append("ScHuodongReason = ")
           .append(getScHuodongReason())
           .append("\n");
        str.append("ScYinxiang = ")
           .append(getScYinxiang())
           .append("\n");
        str.append("ScYinxiangReason = ")
           .append(getScYinxiangReason())
           .append("\n");
        str.append("ScGongxian = ")
           .append(getScGongxian())
           .append("\n");
        str.append("ScGongxianReason = ")
           .append(getScGongxianReason())
           .append("\n");
        str.append("Remark = ")
           .append(getRemark())
           .append("\n");
        str.append("MemberId = ")
           .append(getMemberId())
           .append("\n");
        str.append("MemberName = ")
           .append(getMemberName())
           .append("\n");
        str.append("UpdateTime = ")
           .append(getUpdateTime())
           .append("\n");
        return(str.toString());
    }
}
