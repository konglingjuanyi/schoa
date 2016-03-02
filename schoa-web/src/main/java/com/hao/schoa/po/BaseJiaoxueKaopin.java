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
 * extended all references should be to JiaoxueKaopin
 */
public abstract class BaseJiaoxueKaopin extends BaseObject
{
    /** The Peer class */
    private static final JiaoxueKaopinPeer peer =
        new JiaoxueKaopinPeer();


    /** The value for the id field */
    private int id;

    /** The value for the xueqiId field */
    private int xueqiId = 0;

    /** The value for the banjiId field */
    private int banjiId = 0;

    /** The value for the kechengId field */
    private int kechengId = 0;

    /** The value for the teacherId field */
    private int teacherId = 0;

    /** The value for the name field */
    private String name;

    /** The value for the score field */
    private double score = 0;

    /** The value for the kaopinInfoId field */
    private int kaopinInfoId = 0;

    /** The value for the createTime field */
    private Date createTime;

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
     * Get the Name
     *
     * @return String
     */
    public String getName()
    {
        return name;
    }


    /**
     * Set the value of Name
     *
     * @param v new value
     */
    public void setName(String v) 
    {

        if (!ObjectUtils.equals(this.name, v))
        {
            this.name = v;
            setModified(true);
        }


    }

    /**
     * Get the Score
     *
     * @return double
     */
    public double getScore()
    {
        return score;
    }


    /**
     * Set the value of Score
     *
     * @param v new value
     */
    public void setScore(double v) 
    {

        if (this.score != v)
        {
            this.score = v;
            setModified(true);
        }


    }

    /**
     * Get the KaopinInfoId
     *
     * @return int
     */
    public int getKaopinInfoId()
    {
        return kaopinInfoId;
    }


    /**
     * Set the value of KaopinInfoId
     *
     * @param v new value
     */
    public void setKaopinInfoId(int v) 
    {

        if (this.kaopinInfoId != v)
        {
            this.kaopinInfoId = v;
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
            fieldNames.add("XueqiId");
            fieldNames.add("BanjiId");
            fieldNames.add("KechengId");
            fieldNames.add("TeacherId");
            fieldNames.add("Name");
            fieldNames.add("Score");
            fieldNames.add("KaopinInfoId");
            fieldNames.add("CreateTime");
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
        if (name.equals("Name"))
        {
            return getName();
        }
        if (name.equals("Score"))
        {
            return new Double(getScore());
        }
        if (name.equals("KaopinInfoId"))
        {
            return new Integer(getKaopinInfoId());
        }
        if (name.equals("CreateTime"))
        {
            return getCreateTime();
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
        if (name.equals("Name"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setName((String) value);
            return true;
        }
        if (name.equals("Score"))
        {
            if (value == null || ! (Double.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Double object.");
            }
            setScore(((Double) value).doubleValue());
            return true;
        }
        if (name.equals("KaopinInfoId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setKaopinInfoId(((Integer) value).intValue());
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
        if (name.equals(JiaoxueKaopinPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(JiaoxueKaopinPeer.XUEQI_ID))
        {
            return new Integer(getXueqiId());
        }
        if (name.equals(JiaoxueKaopinPeer.BANJI_ID))
        {
            return new Integer(getBanjiId());
        }
        if (name.equals(JiaoxueKaopinPeer.KECHENG_ID))
        {
            return new Integer(getKechengId());
        }
        if (name.equals(JiaoxueKaopinPeer.TEACHER_ID))
        {
            return new Integer(getTeacherId());
        }
        if (name.equals(JiaoxueKaopinPeer.NAME))
        {
            return getName();
        }
        if (name.equals(JiaoxueKaopinPeer.SCORE))
        {
            return new Double(getScore());
        }
        if (name.equals(JiaoxueKaopinPeer.KAOPIN_INFO_ID))
        {
            return new Integer(getKaopinInfoId());
        }
        if (name.equals(JiaoxueKaopinPeer.CREATE_TIME))
        {
            return getCreateTime();
        }
        if (name.equals(JiaoxueKaopinPeer.MEMBER_ID))
        {
            return new Integer(getMemberId());
        }
        if (name.equals(JiaoxueKaopinPeer.MEMBER_NAME))
        {
            return getMemberName();
        }
        if (name.equals(JiaoxueKaopinPeer.UPDATE_TIME))
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
      if (JiaoxueKaopinPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (JiaoxueKaopinPeer.XUEQI_ID.equals(name))
        {
            return setByName("XueqiId", value);
        }
      if (JiaoxueKaopinPeer.BANJI_ID.equals(name))
        {
            return setByName("BanjiId", value);
        }
      if (JiaoxueKaopinPeer.KECHENG_ID.equals(name))
        {
            return setByName("KechengId", value);
        }
      if (JiaoxueKaopinPeer.TEACHER_ID.equals(name))
        {
            return setByName("TeacherId", value);
        }
      if (JiaoxueKaopinPeer.NAME.equals(name))
        {
            return setByName("Name", value);
        }
      if (JiaoxueKaopinPeer.SCORE.equals(name))
        {
            return setByName("Score", value);
        }
      if (JiaoxueKaopinPeer.KAOPIN_INFO_ID.equals(name))
        {
            return setByName("KaopinInfoId", value);
        }
      if (JiaoxueKaopinPeer.CREATE_TIME.equals(name))
        {
            return setByName("CreateTime", value);
        }
      if (JiaoxueKaopinPeer.MEMBER_ID.equals(name))
        {
            return setByName("MemberId", value);
        }
      if (JiaoxueKaopinPeer.MEMBER_NAME.equals(name))
        {
            return setByName("MemberName", value);
        }
      if (JiaoxueKaopinPeer.UPDATE_TIME.equals(name))
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
            return new Integer(getXueqiId());
        }
        if (pos == 2)
        {
            return new Integer(getBanjiId());
        }
        if (pos == 3)
        {
            return new Integer(getKechengId());
        }
        if (pos == 4)
        {
            return new Integer(getTeacherId());
        }
        if (pos == 5)
        {
            return getName();
        }
        if (pos == 6)
        {
            return new Double(getScore());
        }
        if (pos == 7)
        {
            return new Integer(getKaopinInfoId());
        }
        if (pos == 8)
        {
            return getCreateTime();
        }
        if (pos == 9)
        {
            return new Integer(getMemberId());
        }
        if (pos == 10)
        {
            return getMemberName();
        }
        if (pos == 11)
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
            return setByName("XueqiId", value);
        }
    if (position == 2)
        {
            return setByName("BanjiId", value);
        }
    if (position == 3)
        {
            return setByName("KechengId", value);
        }
    if (position == 4)
        {
            return setByName("TeacherId", value);
        }
    if (position == 5)
        {
            return setByName("Name", value);
        }
    if (position == 6)
        {
            return setByName("Score", value);
        }
    if (position == 7)
        {
            return setByName("KaopinInfoId", value);
        }
    if (position == 8)
        {
            return setByName("CreateTime", value);
        }
    if (position == 9)
        {
            return setByName("MemberId", value);
        }
    if (position == 10)
        {
            return setByName("MemberName", value);
        }
    if (position == 11)
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
        save(JiaoxueKaopinPeer.DATABASE_NAME);
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
                    JiaoxueKaopinPeer.doInsert((JiaoxueKaopin) this, con);
                    setNew(false);
                }
                else
                {
                    JiaoxueKaopinPeer.doUpdate((JiaoxueKaopin) this, con);
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
    public JiaoxueKaopin copy() throws TorqueException
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
    public JiaoxueKaopin copy(Connection con) throws TorqueException
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
    public JiaoxueKaopin copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new JiaoxueKaopin(), deepcopy);
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
    public JiaoxueKaopin copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new JiaoxueKaopin(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected JiaoxueKaopin copyInto(JiaoxueKaopin copyObj) throws TorqueException
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
    protected JiaoxueKaopin copyInto(JiaoxueKaopin copyObj, Connection con) throws TorqueException
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
    protected JiaoxueKaopin copyInto(JiaoxueKaopin copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setXueqiId(xueqiId);
        copyObj.setBanjiId(banjiId);
        copyObj.setKechengId(kechengId);
        copyObj.setTeacherId(teacherId);
        copyObj.setName(name);
        copyObj.setScore(score);
        copyObj.setKaopinInfoId(kaopinInfoId);
        copyObj.setCreateTime(createTime);
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
    protected JiaoxueKaopin copyInto(JiaoxueKaopin copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setXueqiId(xueqiId);
        copyObj.setBanjiId(banjiId);
        copyObj.setKechengId(kechengId);
        copyObj.setTeacherId(teacherId);
        copyObj.setName(name);
        copyObj.setScore(score);
        copyObj.setKaopinInfoId(kaopinInfoId);
        copyObj.setCreateTime(createTime);
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
    public JiaoxueKaopinPeer getPeer()
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
        return JiaoxueKaopinPeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("JiaoxueKaopin:\n");
        str.append("Id = ")
           .append(getId())
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
        str.append("Name = ")
           .append(getName())
           .append("\n");
        str.append("Score = ")
           .append(getScore())
           .append("\n");
        str.append("KaopinInfoId = ")
           .append(getKaopinInfoId())
           .append("\n");
        str.append("CreateTime = ")
           .append(getCreateTime())
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
