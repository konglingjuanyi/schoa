package com.hao.schoa.po;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
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
 * extended all references should be to Kecheng
 */
public abstract class BaseKecheng extends BaseObject
{
    /** The Peer class */
    private static final KechengPeer peer =
        new KechengPeer();


    /** The value for the id field */
    private int id;

    /** The value for the name field */
    private String name;

    /** The value for the teacherId field */
    private int teacherId = 0;

    /** The value for the xueqiId field */
    private int xueqiId = 0;

    /** The value for the keshi field */
    private int keshi = 0;

    /** The value for the jiaocai field */
    private String jiaocai;

    /** The value for the intro field */
    private String intro;

    /** The value for the fileUploadFlags field */
    private String fileUploadFlags;


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
     * Get the Keshi
     *
     * @return int
     */
    public int getKeshi()
    {
        return keshi;
    }


    /**
     * Set the value of Keshi
     *
     * @param v new value
     */
    public void setKeshi(int v) 
    {

        if (this.keshi != v)
        {
            this.keshi = v;
            setModified(true);
        }


    }

    /**
     * Get the Jiaocai
     *
     * @return String
     */
    public String getJiaocai()
    {
        return jiaocai;
    }


    /**
     * Set the value of Jiaocai
     *
     * @param v new value
     */
    public void setJiaocai(String v) 
    {

        if (!ObjectUtils.equals(this.jiaocai, v))
        {
            this.jiaocai = v;
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
     * Get the FileUploadFlags
     *
     * @return String
     */
    public String getFileUploadFlags()
    {
        return fileUploadFlags;
    }


    /**
     * Set the value of FileUploadFlags
     *
     * @param v new value
     */
    public void setFileUploadFlags(String v) 
    {

        if (!ObjectUtils.equals(this.fileUploadFlags, v))
        {
            this.fileUploadFlags = v;
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
            fieldNames.add("Name");
            fieldNames.add("TeacherId");
            fieldNames.add("XueqiId");
            fieldNames.add("Keshi");
            fieldNames.add("Jiaocai");
            fieldNames.add("Intro");
            fieldNames.add("FileUploadFlags");
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
        if (name.equals("Name"))
        {
            return getName();
        }
        if (name.equals("TeacherId"))
        {
            return new Integer(getTeacherId());
        }
        if (name.equals("XueqiId"))
        {
            return new Integer(getXueqiId());
        }
        if (name.equals("Keshi"))
        {
            return new Integer(getKeshi());
        }
        if (name.equals("Jiaocai"))
        {
            return getJiaocai();
        }
        if (name.equals("Intro"))
        {
            return getIntro();
        }
        if (name.equals("FileUploadFlags"))
        {
            return getFileUploadFlags();
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
        if (name.equals("TeacherId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setTeacherId(((Integer) value).intValue());
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
        if (name.equals("Keshi"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setKeshi(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Jiaocai"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setJiaocai((String) value);
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
        if (name.equals("FileUploadFlags"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setFileUploadFlags((String) value);
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
        if (name.equals(KechengPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(KechengPeer.NAME))
        {
            return getName();
        }
        if (name.equals(KechengPeer.TEACHER_ID))
        {
            return new Integer(getTeacherId());
        }
        if (name.equals(KechengPeer.XUEQI_ID))
        {
            return new Integer(getXueqiId());
        }
        if (name.equals(KechengPeer.KESHI))
        {
            return new Integer(getKeshi());
        }
        if (name.equals(KechengPeer.JIAOCAI))
        {
            return getJiaocai();
        }
        if (name.equals(KechengPeer.INTRO))
        {
            return getIntro();
        }
        if (name.equals(KechengPeer.FILE_UPLOAD_FLAGS))
        {
            return getFileUploadFlags();
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
      if (KechengPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (KechengPeer.NAME.equals(name))
        {
            return setByName("Name", value);
        }
      if (KechengPeer.TEACHER_ID.equals(name))
        {
            return setByName("TeacherId", value);
        }
      if (KechengPeer.XUEQI_ID.equals(name))
        {
            return setByName("XueqiId", value);
        }
      if (KechengPeer.KESHI.equals(name))
        {
            return setByName("Keshi", value);
        }
      if (KechengPeer.JIAOCAI.equals(name))
        {
            return setByName("Jiaocai", value);
        }
      if (KechengPeer.INTRO.equals(name))
        {
            return setByName("Intro", value);
        }
      if (KechengPeer.FILE_UPLOAD_FLAGS.equals(name))
        {
            return setByName("FileUploadFlags", value);
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
            return getName();
        }
        if (pos == 2)
        {
            return new Integer(getTeacherId());
        }
        if (pos == 3)
        {
            return new Integer(getXueqiId());
        }
        if (pos == 4)
        {
            return new Integer(getKeshi());
        }
        if (pos == 5)
        {
            return getJiaocai();
        }
        if (pos == 6)
        {
            return getIntro();
        }
        if (pos == 7)
        {
            return getFileUploadFlags();
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
            return setByName("Name", value);
        }
    if (position == 2)
        {
            return setByName("TeacherId", value);
        }
    if (position == 3)
        {
            return setByName("XueqiId", value);
        }
    if (position == 4)
        {
            return setByName("Keshi", value);
        }
    if (position == 5)
        {
            return setByName("Jiaocai", value);
        }
    if (position == 6)
        {
            return setByName("Intro", value);
        }
    if (position == 7)
        {
            return setByName("FileUploadFlags", value);
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
        save(KechengPeer.DATABASE_NAME);
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
                    KechengPeer.doInsert((Kecheng) this, con);
                    setNew(false);
                }
                else
                {
                    KechengPeer.doUpdate((Kecheng) this, con);
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
    public Kecheng copy() throws TorqueException
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
    public Kecheng copy(Connection con) throws TorqueException
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
    public Kecheng copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new Kecheng(), deepcopy);
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
    public Kecheng copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new Kecheng(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected Kecheng copyInto(Kecheng copyObj) throws TorqueException
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
    protected Kecheng copyInto(Kecheng copyObj, Connection con) throws TorqueException
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
    protected Kecheng copyInto(Kecheng copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setName(name);
        copyObj.setTeacherId(teacherId);
        copyObj.setXueqiId(xueqiId);
        copyObj.setKeshi(keshi);
        copyObj.setJiaocai(jiaocai);
        copyObj.setIntro(intro);
        copyObj.setFileUploadFlags(fileUploadFlags);

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
    protected Kecheng copyInto(Kecheng copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setName(name);
        copyObj.setTeacherId(teacherId);
        copyObj.setXueqiId(xueqiId);
        copyObj.setKeshi(keshi);
        copyObj.setJiaocai(jiaocai);
        copyObj.setIntro(intro);
        copyObj.setFileUploadFlags(fileUploadFlags);

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
    public KechengPeer getPeer()
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
        return KechengPeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("Kecheng:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("Name = ")
           .append(getName())
           .append("\n");
        str.append("TeacherId = ")
           .append(getTeacherId())
           .append("\n");
        str.append("XueqiId = ")
           .append(getXueqiId())
           .append("\n");
        str.append("Keshi = ")
           .append(getKeshi())
           .append("\n");
        str.append("Jiaocai = ")
           .append(getJiaocai())
           .append("\n");
        str.append("Intro = ")
           .append(getIntro())
           .append("\n");
        str.append("FileUploadFlags = ")
           .append(getFileUploadFlags())
           .append("\n");
        return(str.toString());
    }
}
