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
 * extended all references should be to JiaoxueFile
 */
public abstract class BaseJiaoxueFile extends BaseObject
{
    /** The Peer class */
    private static final JiaoxueFilePeer peer =
        new JiaoxueFilePeer();


    /** The value for the id field */
    private int id;

    /** The value for the xueqiId field */
    private int xueqiId = 0;

    /** The value for the kechengId field */
    private int kechengId = 0;

    /** The value for the teacherId field */
    private int teacherId = 0;

    /** The value for the fileFlag field */
    private int fileFlag = 0;

    /** The value for the fileScore field */
    private double fileScore = 0;

    /** The value for the name field */
    private String name;

    /** The value for the saveName field */
    private String saveName;

    /** The value for the intro field */
    private String intro;

    /** The value for the fileSize field */
    private int fileSize = 0;

    /** The value for the memberId field */
    private int memberId;

    /** The value for the memberName field */
    private String memberName;

    /** The value for the uptime field */
    private Date uptime;


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
     * Get the FileFlag
     *
     * @return int
     */
    public int getFileFlag()
    {
        return fileFlag;
    }


    /**
     * Set the value of FileFlag
     *
     * @param v new value
     */
    public void setFileFlag(int v) 
    {

        if (this.fileFlag != v)
        {
            this.fileFlag = v;
            setModified(true);
        }


    }

    /**
     * Get the FileScore
     *
     * @return double
     */
    public double getFileScore()
    {
        return fileScore;
    }


    /**
     * Set the value of FileScore
     *
     * @param v new value
     */
    public void setFileScore(double v) 
    {

        if (this.fileScore != v)
        {
            this.fileScore = v;
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
     * Get the SaveName
     *
     * @return String
     */
    public String getSaveName()
    {
        return saveName;
    }


    /**
     * Set the value of SaveName
     *
     * @param v new value
     */
    public void setSaveName(String v) 
    {

        if (!ObjectUtils.equals(this.saveName, v))
        {
            this.saveName = v;
            setModified(true);
        }


    }

    /**
     * Get the Intro
     *
     * @return String
     */
    public String getIntro()
    {
        return intro;
    }


    /**
     * Set the value of Intro
     *
     * @param v new value
     */
    public void setIntro(String v) 
    {

        if (!ObjectUtils.equals(this.intro, v))
        {
            this.intro = v;
            setModified(true);
        }


    }

    /**
     * Get the FileSize
     *
     * @return int
     */
    public int getFileSize()
    {
        return fileSize;
    }


    /**
     * Set the value of FileSize
     *
     * @param v new value
     */
    public void setFileSize(int v) 
    {

        if (this.fileSize != v)
        {
            this.fileSize = v;
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
     * Get the Uptime
     *
     * @return Date
     */
    public Date getUptime()
    {
        return uptime;
    }


    /**
     * Set the value of Uptime
     *
     * @param v new value
     */
    public void setUptime(Date v) 
    {

        if (!ObjectUtils.equals(this.uptime, v))
        {
            this.uptime = v;
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
            fieldNames.add("KechengId");
            fieldNames.add("TeacherId");
            fieldNames.add("FileFlag");
            fieldNames.add("FileScore");
            fieldNames.add("Name");
            fieldNames.add("SaveName");
            fieldNames.add("Intro");
            fieldNames.add("FileSize");
            fieldNames.add("MemberId");
            fieldNames.add("MemberName");
            fieldNames.add("Uptime");
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
        if (name.equals("KechengId"))
        {
            return new Integer(getKechengId());
        }
        if (name.equals("TeacherId"))
        {
            return new Integer(getTeacherId());
        }
        if (name.equals("FileFlag"))
        {
            return new Integer(getFileFlag());
        }
        if (name.equals("FileScore"))
        {
            return new Double(getFileScore());
        }
        if (name.equals("Name"))
        {
            return getName();
        }
        if (name.equals("SaveName"))
        {
            return getSaveName();
        }
        if (name.equals("Intro"))
        {
            return getIntro();
        }
        if (name.equals("FileSize"))
        {
            return new Integer(getFileSize());
        }
        if (name.equals("MemberId"))
        {
            return new Integer(getMemberId());
        }
        if (name.equals("MemberName"))
        {
            return getMemberName();
        }
        if (name.equals("Uptime"))
        {
            return getUptime();
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
        if (name.equals("FileFlag"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setFileFlag(((Integer) value).intValue());
            return true;
        }
        if (name.equals("FileScore"))
        {
            if (value == null || ! (Double.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Double object.");
            }
            setFileScore(((Double) value).doubleValue());
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
        if (name.equals("SaveName"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setSaveName((String) value);
            return true;
        }
        if (name.equals("Intro"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setIntro((String) value);
            return true;
        }
        if (name.equals("FileSize"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setFileSize(((Integer) value).intValue());
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
        if (name.equals("Uptime"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setUptime((Date) value);
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
        if (name.equals(JiaoxueFilePeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(JiaoxueFilePeer.XUEQI_ID))
        {
            return new Integer(getXueqiId());
        }
        if (name.equals(JiaoxueFilePeer.KECHENG_ID))
        {
            return new Integer(getKechengId());
        }
        if (name.equals(JiaoxueFilePeer.TEACHER_ID))
        {
            return new Integer(getTeacherId());
        }
        if (name.equals(JiaoxueFilePeer.FILE_FLAG))
        {
            return new Integer(getFileFlag());
        }
        if (name.equals(JiaoxueFilePeer.FILE_SCORE))
        {
            return new Double(getFileScore());
        }
        if (name.equals(JiaoxueFilePeer.NAME))
        {
            return getName();
        }
        if (name.equals(JiaoxueFilePeer.SAVE_NAME))
        {
            return getSaveName();
        }
        if (name.equals(JiaoxueFilePeer.INTRO))
        {
            return getIntro();
        }
        if (name.equals(JiaoxueFilePeer.FILE_SIZE))
        {
            return new Integer(getFileSize());
        }
        if (name.equals(JiaoxueFilePeer.MEMBER_ID))
        {
            return new Integer(getMemberId());
        }
        if (name.equals(JiaoxueFilePeer.MEMBER_NAME))
        {
            return getMemberName();
        }
        if (name.equals(JiaoxueFilePeer.UPTIME))
        {
            return getUptime();
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
      if (JiaoxueFilePeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (JiaoxueFilePeer.XUEQI_ID.equals(name))
        {
            return setByName("XueqiId", value);
        }
      if (JiaoxueFilePeer.KECHENG_ID.equals(name))
        {
            return setByName("KechengId", value);
        }
      if (JiaoxueFilePeer.TEACHER_ID.equals(name))
        {
            return setByName("TeacherId", value);
        }
      if (JiaoxueFilePeer.FILE_FLAG.equals(name))
        {
            return setByName("FileFlag", value);
        }
      if (JiaoxueFilePeer.FILE_SCORE.equals(name))
        {
            return setByName("FileScore", value);
        }
      if (JiaoxueFilePeer.NAME.equals(name))
        {
            return setByName("Name", value);
        }
      if (JiaoxueFilePeer.SAVE_NAME.equals(name))
        {
            return setByName("SaveName", value);
        }
      if (JiaoxueFilePeer.INTRO.equals(name))
        {
            return setByName("Intro", value);
        }
      if (JiaoxueFilePeer.FILE_SIZE.equals(name))
        {
            return setByName("FileSize", value);
        }
      if (JiaoxueFilePeer.MEMBER_ID.equals(name))
        {
            return setByName("MemberId", value);
        }
      if (JiaoxueFilePeer.MEMBER_NAME.equals(name))
        {
            return setByName("MemberName", value);
        }
      if (JiaoxueFilePeer.UPTIME.equals(name))
        {
            return setByName("Uptime", value);
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
            return new Integer(getKechengId());
        }
        if (pos == 3)
        {
            return new Integer(getTeacherId());
        }
        if (pos == 4)
        {
            return new Integer(getFileFlag());
        }
        if (pos == 5)
        {
            return new Double(getFileScore());
        }
        if (pos == 6)
        {
            return getName();
        }
        if (pos == 7)
        {
            return getSaveName();
        }
        if (pos == 8)
        {
            return getIntro();
        }
        if (pos == 9)
        {
            return new Integer(getFileSize());
        }
        if (pos == 10)
        {
            return new Integer(getMemberId());
        }
        if (pos == 11)
        {
            return getMemberName();
        }
        if (pos == 12)
        {
            return getUptime();
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
            return setByName("KechengId", value);
        }
    if (position == 3)
        {
            return setByName("TeacherId", value);
        }
    if (position == 4)
        {
            return setByName("FileFlag", value);
        }
    if (position == 5)
        {
            return setByName("FileScore", value);
        }
    if (position == 6)
        {
            return setByName("Name", value);
        }
    if (position == 7)
        {
            return setByName("SaveName", value);
        }
    if (position == 8)
        {
            return setByName("Intro", value);
        }
    if (position == 9)
        {
            return setByName("FileSize", value);
        }
    if (position == 10)
        {
            return setByName("MemberId", value);
        }
    if (position == 11)
        {
            return setByName("MemberName", value);
        }
    if (position == 12)
        {
            return setByName("Uptime", value);
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
        save(JiaoxueFilePeer.DATABASE_NAME);
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
                    JiaoxueFilePeer.doInsert((JiaoxueFile) this, con);
                    setNew(false);
                }
                else
                {
                    JiaoxueFilePeer.doUpdate((JiaoxueFile) this, con);
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
    public JiaoxueFile copy() throws TorqueException
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
    public JiaoxueFile copy(Connection con) throws TorqueException
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
    public JiaoxueFile copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new JiaoxueFile(), deepcopy);
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
    public JiaoxueFile copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new JiaoxueFile(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected JiaoxueFile copyInto(JiaoxueFile copyObj) throws TorqueException
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
    protected JiaoxueFile copyInto(JiaoxueFile copyObj, Connection con) throws TorqueException
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
    protected JiaoxueFile copyInto(JiaoxueFile copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setXueqiId(xueqiId);
        copyObj.setKechengId(kechengId);
        copyObj.setTeacherId(teacherId);
        copyObj.setFileFlag(fileFlag);
        copyObj.setFileScore(fileScore);
        copyObj.setName(name);
        copyObj.setSaveName(saveName);
        copyObj.setIntro(intro);
        copyObj.setFileSize(fileSize);
        copyObj.setMemberId(memberId);
        copyObj.setMemberName(memberName);
        copyObj.setUptime(uptime);

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
    protected JiaoxueFile copyInto(JiaoxueFile copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setXueqiId(xueqiId);
        copyObj.setKechengId(kechengId);
        copyObj.setTeacherId(teacherId);
        copyObj.setFileFlag(fileFlag);
        copyObj.setFileScore(fileScore);
        copyObj.setName(name);
        copyObj.setSaveName(saveName);
        copyObj.setIntro(intro);
        copyObj.setFileSize(fileSize);
        copyObj.setMemberId(memberId);
        copyObj.setMemberName(memberName);
        copyObj.setUptime(uptime);

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
    public JiaoxueFilePeer getPeer()
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
        return JiaoxueFilePeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("JiaoxueFile:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("XueqiId = ")
           .append(getXueqiId())
           .append("\n");
        str.append("KechengId = ")
           .append(getKechengId())
           .append("\n");
        str.append("TeacherId = ")
           .append(getTeacherId())
           .append("\n");
        str.append("FileFlag = ")
           .append(getFileFlag())
           .append("\n");
        str.append("FileScore = ")
           .append(getFileScore())
           .append("\n");
        str.append("Name = ")
           .append(getName())
           .append("\n");
        str.append("SaveName = ")
           .append(getSaveName())
           .append("\n");
        str.append("Intro = ")
           .append(getIntro())
           .append("\n");
        str.append("FileSize = ")
           .append(getFileSize())
           .append("\n");
        str.append("MemberId = ")
           .append(getMemberId())
           .append("\n");
        str.append("MemberName = ")
           .append(getMemberName())
           .append("\n");
        str.append("Uptime = ")
           .append(getUptime())
           .append("\n");
        return(str.toString());
    }
}
