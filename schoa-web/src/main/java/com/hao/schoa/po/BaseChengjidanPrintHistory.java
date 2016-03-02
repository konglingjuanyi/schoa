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
 * extended all references should be to ChengjidanPrintHistory
 */
public abstract class BaseChengjidanPrintHistory extends BaseObject
{
    /** The Peer class */
    private static final ChengjidanPrintHistoryPeer peer =
        new ChengjidanPrintHistoryPeer();


    /** The value for the id field */
    private int id;

    /** The value for the studentId field */
    private int studentId = 0;

    /** The value for the classesId field */
    private int classesId = 0;

    /** The value for the snapshot field */
    private String snapshot;

    /** The value for the intro field */
    private String intro;

    /** The value for the operator field */
    private String operator;

    /** The value for the createTime field */
    private Date createTime;


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
     * Get the StudentId
     *
     * @return int
     */
    public int getStudentId()
    {
        return studentId;
    }


    /**
     * Set the value of StudentId
     *
     * @param v new value
     */
    public void setStudentId(int v) 
    {

        if (this.studentId != v)
        {
            this.studentId = v;
            setModified(true);
        }


    }

    /**
     * Get the ClassesId
     *
     * @return int
     */
    public int getClassesId()
    {
        return classesId;
    }


    /**
     * Set the value of ClassesId
     *
     * @param v new value
     */
    public void setClassesId(int v) 
    {

        if (this.classesId != v)
        {
            this.classesId = v;
            setModified(true);
        }


    }

    /**
     * Get the Snapshot
     *
     * @return String
     */
    public String getSnapshot()
    {
        return snapshot;
    }


    /**
     * Set the value of Snapshot
     *
     * @param v new value
     */
    public void setSnapshot(String v) 
    {

        if (!ObjectUtils.equals(this.snapshot, v))
        {
            this.snapshot = v;
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
     * Get the Operator
     *
     * @return String
     */
    public String getOperator()
    {
        return operator;
    }


    /**
     * Set the value of Operator
     *
     * @param v new value
     */
    public void setOperator(String v) 
    {

        if (!ObjectUtils.equals(this.operator, v))
        {
            this.operator = v;
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
            fieldNames.add("StudentId");
            fieldNames.add("ClassesId");
            fieldNames.add("Snapshot");
            fieldNames.add("Intro");
            fieldNames.add("Operator");
            fieldNames.add("CreateTime");
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
        if (name.equals("StudentId"))
        {
            return new Integer(getStudentId());
        }
        if (name.equals("ClassesId"))
        {
            return new Integer(getClassesId());
        }
        if (name.equals("Snapshot"))
        {
            return getSnapshot();
        }
        if (name.equals("Intro"))
        {
            return getIntro();
        }
        if (name.equals("Operator"))
        {
            return getOperator();
        }
        if (name.equals("CreateTime"))
        {
            return getCreateTime();
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
        if (name.equals("StudentId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setStudentId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("ClassesId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setClassesId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Snapshot"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setSnapshot((String) value);
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
        if (name.equals("Operator"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setOperator((String) value);
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
        if (name.equals(ChengjidanPrintHistoryPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(ChengjidanPrintHistoryPeer.STUDENT_ID))
        {
            return new Integer(getStudentId());
        }
        if (name.equals(ChengjidanPrintHistoryPeer.CLASSES_ID))
        {
            return new Integer(getClassesId());
        }
        if (name.equals(ChengjidanPrintHistoryPeer.SNAPSHOT))
        {
            return getSnapshot();
        }
        if (name.equals(ChengjidanPrintHistoryPeer.INTRO))
        {
            return getIntro();
        }
        if (name.equals(ChengjidanPrintHistoryPeer.OPERATOR))
        {
            return getOperator();
        }
        if (name.equals(ChengjidanPrintHistoryPeer.CREATE_TIME))
        {
            return getCreateTime();
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
      if (ChengjidanPrintHistoryPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (ChengjidanPrintHistoryPeer.STUDENT_ID.equals(name))
        {
            return setByName("StudentId", value);
        }
      if (ChengjidanPrintHistoryPeer.CLASSES_ID.equals(name))
        {
            return setByName("ClassesId", value);
        }
      if (ChengjidanPrintHistoryPeer.SNAPSHOT.equals(name))
        {
            return setByName("Snapshot", value);
        }
      if (ChengjidanPrintHistoryPeer.INTRO.equals(name))
        {
            return setByName("Intro", value);
        }
      if (ChengjidanPrintHistoryPeer.OPERATOR.equals(name))
        {
            return setByName("Operator", value);
        }
      if (ChengjidanPrintHistoryPeer.CREATE_TIME.equals(name))
        {
            return setByName("CreateTime", value);
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
            return new Integer(getStudentId());
        }
        if (pos == 2)
        {
            return new Integer(getClassesId());
        }
        if (pos == 3)
        {
            return getSnapshot();
        }
        if (pos == 4)
        {
            return getIntro();
        }
        if (pos == 5)
        {
            return getOperator();
        }
        if (pos == 6)
        {
            return getCreateTime();
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
            return setByName("StudentId", value);
        }
    if (position == 2)
        {
            return setByName("ClassesId", value);
        }
    if (position == 3)
        {
            return setByName("Snapshot", value);
        }
    if (position == 4)
        {
            return setByName("Intro", value);
        }
    if (position == 5)
        {
            return setByName("Operator", value);
        }
    if (position == 6)
        {
            return setByName("CreateTime", value);
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
        save(ChengjidanPrintHistoryPeer.DATABASE_NAME);
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
                    ChengjidanPrintHistoryPeer.doInsert((ChengjidanPrintHistory) this, con);
                    setNew(false);
                }
                else
                {
                    ChengjidanPrintHistoryPeer.doUpdate((ChengjidanPrintHistory) this, con);
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
    public ChengjidanPrintHistory copy() throws TorqueException
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
    public ChengjidanPrintHistory copy(Connection con) throws TorqueException
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
    public ChengjidanPrintHistory copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new ChengjidanPrintHistory(), deepcopy);
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
    public ChengjidanPrintHistory copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new ChengjidanPrintHistory(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected ChengjidanPrintHistory copyInto(ChengjidanPrintHistory copyObj) throws TorqueException
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
    protected ChengjidanPrintHistory copyInto(ChengjidanPrintHistory copyObj, Connection con) throws TorqueException
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
    protected ChengjidanPrintHistory copyInto(ChengjidanPrintHistory copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setStudentId(studentId);
        copyObj.setClassesId(classesId);
        copyObj.setSnapshot(snapshot);
        copyObj.setIntro(intro);
        copyObj.setOperator(operator);
        copyObj.setCreateTime(createTime);

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
    protected ChengjidanPrintHistory copyInto(ChengjidanPrintHistory copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setStudentId(studentId);
        copyObj.setClassesId(classesId);
        copyObj.setSnapshot(snapshot);
        copyObj.setIntro(intro);
        copyObj.setOperator(operator);
        copyObj.setCreateTime(createTime);

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
    public ChengjidanPrintHistoryPeer getPeer()
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
        return ChengjidanPrintHistoryPeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("ChengjidanPrintHistory:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("StudentId = ")
           .append(getStudentId())
           .append("\n");
        str.append("ClassesId = ")
           .append(getClassesId())
           .append("\n");
        str.append("Snapshot = ")
           .append(getSnapshot())
           .append("\n");
        str.append("Intro = ")
           .append(getIntro())
           .append("\n");
        str.append("Operator = ")
           .append(getOperator())
           .append("\n");
        str.append("CreateTime = ")
           .append(getCreateTime())
           .append("\n");
        return(str.toString());
    }
}
