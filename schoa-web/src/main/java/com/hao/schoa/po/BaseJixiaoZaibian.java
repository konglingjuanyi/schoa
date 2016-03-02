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
 * extended all references should be to JixiaoZaibian
 */
public abstract class BaseJixiaoZaibian extends BaseObject
{
    /** The Peer class */
    private static final JixiaoZaibianPeer peer =
        new JixiaoZaibianPeer();


    /** The value for the id field */
    private int id;

    /** The value for the youxiu field */
    private int youxiu = 0;

    /** The value for the xueqiId field */
    private int xueqiId = 0;

    /** The value for the teacherId field */
    private int teacherId = 0;

    /** The value for the teacherName field */
    private String teacherName;

    /** The value for the scKaihuiReason field */
    private String scKaihuiReason;

    /** The value for the scBanzhuren field */
    private String scBanzhuren;

    /** The value for the scJianren field */
    private String scJianren;

    /** The value for the scOther field */
    private String scOther;

    /** The value for the scJiang field */
    private String scJiang;

    /** The value for the scGongzuoliang field */
    private String scGongzuoliang;

    /** The value for the scKaoheFile field */
    private String scKaoheFile;

    /** The value for the scKaoheFilename field */
    private String scKaoheFilename;

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
     * Get the ScBanzhuren
     *
     * @return String
     */
    public String getScBanzhuren()
    {
        return scBanzhuren;
    }


    /**
     * Set the value of ScBanzhuren
     *
     * @param v new value
     */
    public void setScBanzhuren(String v) 
    {

        if (!ObjectUtils.equals(this.scBanzhuren, v))
        {
            this.scBanzhuren = v;
            setModified(true);
        }


    }

    /**
     * Get the ScJianren
     *
     * @return String
     */
    public String getScJianren()
    {
        return scJianren;
    }


    /**
     * Set the value of ScJianren
     *
     * @param v new value
     */
    public void setScJianren(String v) 
    {

        if (!ObjectUtils.equals(this.scJianren, v))
        {
            this.scJianren = v;
            setModified(true);
        }


    }

    /**
     * Get the ScOther
     *
     * @return String
     */
    public String getScOther()
    {
        return scOther;
    }


    /**
     * Set the value of ScOther
     *
     * @param v new value
     */
    public void setScOther(String v) 
    {

        if (!ObjectUtils.equals(this.scOther, v))
        {
            this.scOther = v;
            setModified(true);
        }


    }

    /**
     * Get the ScJiang
     *
     * @return String
     */
    public String getScJiang()
    {
        return scJiang;
    }


    /**
     * Set the value of ScJiang
     *
     * @param v new value
     */
    public void setScJiang(String v) 
    {

        if (!ObjectUtils.equals(this.scJiang, v))
        {
            this.scJiang = v;
            setModified(true);
        }


    }

    /**
     * Get the ScGongzuoliang
     *
     * @return String
     */
    public String getScGongzuoliang()
    {
        return scGongzuoliang;
    }


    /**
     * Set the value of ScGongzuoliang
     *
     * @param v new value
     */
    public void setScGongzuoliang(String v) 
    {

        if (!ObjectUtils.equals(this.scGongzuoliang, v))
        {
            this.scGongzuoliang = v;
            setModified(true);
        }


    }

    /**
     * Get the ScKaoheFile
     *
     * @return String
     */
    public String getScKaoheFile()
    {
        return scKaoheFile;
    }


    /**
     * Set the value of ScKaoheFile
     *
     * @param v new value
     */
    public void setScKaoheFile(String v) 
    {

        if (!ObjectUtils.equals(this.scKaoheFile, v))
        {
            this.scKaoheFile = v;
            setModified(true);
        }


    }

    /**
     * Get the ScKaoheFilename
     *
     * @return String
     */
    public String getScKaoheFilename()
    {
        return scKaoheFilename;
    }


    /**
     * Set the value of ScKaoheFilename
     *
     * @param v new value
     */
    public void setScKaoheFilename(String v) 
    {

        if (!ObjectUtils.equals(this.scKaoheFilename, v))
        {
            this.scKaoheFilename = v;
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
            fieldNames.add("TeacherId");
            fieldNames.add("TeacherName");
            fieldNames.add("ScKaihuiReason");
            fieldNames.add("ScBanzhuren");
            fieldNames.add("ScJianren");
            fieldNames.add("ScOther");
            fieldNames.add("ScJiang");
            fieldNames.add("ScGongzuoliang");
            fieldNames.add("ScKaoheFile");
            fieldNames.add("ScKaoheFilename");
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
        if (name.equals("TeacherId"))
        {
            return new Integer(getTeacherId());
        }
        if (name.equals("TeacherName"))
        {
            return getTeacherName();
        }
        if (name.equals("ScKaihuiReason"))
        {
            return getScKaihuiReason();
        }
        if (name.equals("ScBanzhuren"))
        {
            return getScBanzhuren();
        }
        if (name.equals("ScJianren"))
        {
            return getScJianren();
        }
        if (name.equals("ScOther"))
        {
            return getScOther();
        }
        if (name.equals("ScJiang"))
        {
            return getScJiang();
        }
        if (name.equals("ScGongzuoliang"))
        {
            return getScGongzuoliang();
        }
        if (name.equals("ScKaoheFile"))
        {
            return getScKaoheFile();
        }
        if (name.equals("ScKaoheFilename"))
        {
            return getScKaoheFilename();
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
        if (name.equals("ScBanzhuren"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setScBanzhuren((String) value);
            return true;
        }
        if (name.equals("ScJianren"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setScJianren((String) value);
            return true;
        }
        if (name.equals("ScOther"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setScOther((String) value);
            return true;
        }
        if (name.equals("ScJiang"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setScJiang((String) value);
            return true;
        }
        if (name.equals("ScGongzuoliang"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setScGongzuoliang((String) value);
            return true;
        }
        if (name.equals("ScKaoheFile"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setScKaoheFile((String) value);
            return true;
        }
        if (name.equals("ScKaoheFilename"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setScKaoheFilename((String) value);
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
        if (name.equals(JixiaoZaibianPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(JixiaoZaibianPeer.YOUXIU))
        {
            return new Integer(getYouxiu());
        }
        if (name.equals(JixiaoZaibianPeer.XUEQI_ID))
        {
            return new Integer(getXueqiId());
        }
        if (name.equals(JixiaoZaibianPeer.TEACHER_ID))
        {
            return new Integer(getTeacherId());
        }
        if (name.equals(JixiaoZaibianPeer.TEACHER_NAME))
        {
            return getTeacherName();
        }
        if (name.equals(JixiaoZaibianPeer.SC_KAIHUI_REASON))
        {
            return getScKaihuiReason();
        }
        if (name.equals(JixiaoZaibianPeer.SC_BANZHUREN))
        {
            return getScBanzhuren();
        }
        if (name.equals(JixiaoZaibianPeer.SC_JIANREN))
        {
            return getScJianren();
        }
        if (name.equals(JixiaoZaibianPeer.SC_OTHER))
        {
            return getScOther();
        }
        if (name.equals(JixiaoZaibianPeer.SC_JIANG))
        {
            return getScJiang();
        }
        if (name.equals(JixiaoZaibianPeer.SC_GONGZUOLIANG))
        {
            return getScGongzuoliang();
        }
        if (name.equals(JixiaoZaibianPeer.SC_KAOHE_FILE))
        {
            return getScKaoheFile();
        }
        if (name.equals(JixiaoZaibianPeer.SC_KAOHE_FILENAME))
        {
            return getScKaoheFilename();
        }
        if (name.equals(JixiaoZaibianPeer.REMARK))
        {
            return getRemark();
        }
        if (name.equals(JixiaoZaibianPeer.MEMBER_ID))
        {
            return new Integer(getMemberId());
        }
        if (name.equals(JixiaoZaibianPeer.MEMBER_NAME))
        {
            return getMemberName();
        }
        if (name.equals(JixiaoZaibianPeer.UPDATE_TIME))
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
      if (JixiaoZaibianPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (JixiaoZaibianPeer.YOUXIU.equals(name))
        {
            return setByName("Youxiu", value);
        }
      if (JixiaoZaibianPeer.XUEQI_ID.equals(name))
        {
            return setByName("XueqiId", value);
        }
      if (JixiaoZaibianPeer.TEACHER_ID.equals(name))
        {
            return setByName("TeacherId", value);
        }
      if (JixiaoZaibianPeer.TEACHER_NAME.equals(name))
        {
            return setByName("TeacherName", value);
        }
      if (JixiaoZaibianPeer.SC_KAIHUI_REASON.equals(name))
        {
            return setByName("ScKaihuiReason", value);
        }
      if (JixiaoZaibianPeer.SC_BANZHUREN.equals(name))
        {
            return setByName("ScBanzhuren", value);
        }
      if (JixiaoZaibianPeer.SC_JIANREN.equals(name))
        {
            return setByName("ScJianren", value);
        }
      if (JixiaoZaibianPeer.SC_OTHER.equals(name))
        {
            return setByName("ScOther", value);
        }
      if (JixiaoZaibianPeer.SC_JIANG.equals(name))
        {
            return setByName("ScJiang", value);
        }
      if (JixiaoZaibianPeer.SC_GONGZUOLIANG.equals(name))
        {
            return setByName("ScGongzuoliang", value);
        }
      if (JixiaoZaibianPeer.SC_KAOHE_FILE.equals(name))
        {
            return setByName("ScKaoheFile", value);
        }
      if (JixiaoZaibianPeer.SC_KAOHE_FILENAME.equals(name))
        {
            return setByName("ScKaoheFilename", value);
        }
      if (JixiaoZaibianPeer.REMARK.equals(name))
        {
            return setByName("Remark", value);
        }
      if (JixiaoZaibianPeer.MEMBER_ID.equals(name))
        {
            return setByName("MemberId", value);
        }
      if (JixiaoZaibianPeer.MEMBER_NAME.equals(name))
        {
            return setByName("MemberName", value);
        }
      if (JixiaoZaibianPeer.UPDATE_TIME.equals(name))
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
            return new Integer(getTeacherId());
        }
        if (pos == 4)
        {
            return getTeacherName();
        }
        if (pos == 5)
        {
            return getScKaihuiReason();
        }
        if (pos == 6)
        {
            return getScBanzhuren();
        }
        if (pos == 7)
        {
            return getScJianren();
        }
        if (pos == 8)
        {
            return getScOther();
        }
        if (pos == 9)
        {
            return getScJiang();
        }
        if (pos == 10)
        {
            return getScGongzuoliang();
        }
        if (pos == 11)
        {
            return getScKaoheFile();
        }
        if (pos == 12)
        {
            return getScKaoheFilename();
        }
        if (pos == 13)
        {
            return getRemark();
        }
        if (pos == 14)
        {
            return new Integer(getMemberId());
        }
        if (pos == 15)
        {
            return getMemberName();
        }
        if (pos == 16)
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
            return setByName("TeacherId", value);
        }
    if (position == 4)
        {
            return setByName("TeacherName", value);
        }
    if (position == 5)
        {
            return setByName("ScKaihuiReason", value);
        }
    if (position == 6)
        {
            return setByName("ScBanzhuren", value);
        }
    if (position == 7)
        {
            return setByName("ScJianren", value);
        }
    if (position == 8)
        {
            return setByName("ScOther", value);
        }
    if (position == 9)
        {
            return setByName("ScJiang", value);
        }
    if (position == 10)
        {
            return setByName("ScGongzuoliang", value);
        }
    if (position == 11)
        {
            return setByName("ScKaoheFile", value);
        }
    if (position == 12)
        {
            return setByName("ScKaoheFilename", value);
        }
    if (position == 13)
        {
            return setByName("Remark", value);
        }
    if (position == 14)
        {
            return setByName("MemberId", value);
        }
    if (position == 15)
        {
            return setByName("MemberName", value);
        }
    if (position == 16)
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
        save(JixiaoZaibianPeer.DATABASE_NAME);
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
                    JixiaoZaibianPeer.doInsert((JixiaoZaibian) this, con);
                    setNew(false);
                }
                else
                {
                    JixiaoZaibianPeer.doUpdate((JixiaoZaibian) this, con);
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
    public JixiaoZaibian copy() throws TorqueException
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
    public JixiaoZaibian copy(Connection con) throws TorqueException
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
    public JixiaoZaibian copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new JixiaoZaibian(), deepcopy);
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
    public JixiaoZaibian copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new JixiaoZaibian(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected JixiaoZaibian copyInto(JixiaoZaibian copyObj) throws TorqueException
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
    protected JixiaoZaibian copyInto(JixiaoZaibian copyObj, Connection con) throws TorqueException
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
    protected JixiaoZaibian copyInto(JixiaoZaibian copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setYouxiu(youxiu);
        copyObj.setXueqiId(xueqiId);
        copyObj.setTeacherId(teacherId);
        copyObj.setTeacherName(teacherName);
        copyObj.setScKaihuiReason(scKaihuiReason);
        copyObj.setScBanzhuren(scBanzhuren);
        copyObj.setScJianren(scJianren);
        copyObj.setScOther(scOther);
        copyObj.setScJiang(scJiang);
        copyObj.setScGongzuoliang(scGongzuoliang);
        copyObj.setScKaoheFile(scKaoheFile);
        copyObj.setScKaoheFilename(scKaoheFilename);
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
    protected JixiaoZaibian copyInto(JixiaoZaibian copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setYouxiu(youxiu);
        copyObj.setXueqiId(xueqiId);
        copyObj.setTeacherId(teacherId);
        copyObj.setTeacherName(teacherName);
        copyObj.setScKaihuiReason(scKaihuiReason);
        copyObj.setScBanzhuren(scBanzhuren);
        copyObj.setScJianren(scJianren);
        copyObj.setScOther(scOther);
        copyObj.setScJiang(scJiang);
        copyObj.setScGongzuoliang(scGongzuoliang);
        copyObj.setScKaoheFile(scKaoheFile);
        copyObj.setScKaoheFilename(scKaoheFilename);
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
    public JixiaoZaibianPeer getPeer()
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
        return JixiaoZaibianPeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("JixiaoZaibian:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("Youxiu = ")
           .append(getYouxiu())
           .append("\n");
        str.append("XueqiId = ")
           .append(getXueqiId())
           .append("\n");
        str.append("TeacherId = ")
           .append(getTeacherId())
           .append("\n");
        str.append("TeacherName = ")
           .append(getTeacherName())
           .append("\n");
        str.append("ScKaihuiReason = ")
           .append(getScKaihuiReason())
           .append("\n");
        str.append("ScBanzhuren = ")
           .append(getScBanzhuren())
           .append("\n");
        str.append("ScJianren = ")
           .append(getScJianren())
           .append("\n");
        str.append("ScOther = ")
           .append(getScOther())
           .append("\n");
        str.append("ScJiang = ")
           .append(getScJiang())
           .append("\n");
        str.append("ScGongzuoliang = ")
           .append(getScGongzuoliang())
           .append("\n");
        str.append("ScKaoheFile = ")
           .append(getScKaoheFile())
           .append("\n");
        str.append("ScKaoheFilename = ")
           .append(getScKaoheFilename())
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
