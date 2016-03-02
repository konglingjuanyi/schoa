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
 * extended all references should be to ClassesKecheng
 */
public abstract class BaseClassesKecheng extends BaseObject
{
    /** The Peer class */
    private static final ClassesKechengPeer peer =
        new ClassesKechengPeer();


    /** The value for the id field */
    private int id;

    /** The value for the classesId field */
    private int classesId = 0;

    /** The value for the kechengId field */
    private int kechengId = 0;

    /** The value for the kechengStart field */
    private Date kechengStart;

    /** The value for the kechengEnd field */
    private Date kechengEnd;

    /** The value for the week field */
    private int week = 0;


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
     * Get the KechengStart
     *
     * @return Date
     */
    public Date getKechengStart()
    {
        return kechengStart;
    }


    /**
     * Set the value of KechengStart
     *
     * @param v new value
     */
    public void setKechengStart(Date v) 
    {

        if (!ObjectUtils.equals(this.kechengStart, v))
        {
            this.kechengStart = v;
            setModified(true);
        }


    }

    /**
     * Get the KechengEnd
     *
     * @return Date
     */
    public Date getKechengEnd()
    {
        return kechengEnd;
    }


    /**
     * Set the value of KechengEnd
     *
     * @param v new value
     */
    public void setKechengEnd(Date v) 
    {

        if (!ObjectUtils.equals(this.kechengEnd, v))
        {
            this.kechengEnd = v;
            setModified(true);
        }


    }

    /**
     * Get the Week
     *
     * @return int
     */
    public int getWeek()
    {
        return week;
    }


    /**
     * Set the value of Week
     *
     * @param v new value
     */
    public void setWeek(int v) 
    {

        if (this.week != v)
        {
            this.week = v;
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
            fieldNames.add("ClassesId");
            fieldNames.add("KechengId");
            fieldNames.add("KechengStart");
            fieldNames.add("KechengEnd");
            fieldNames.add("Week");
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
        if (name.equals("ClassesId"))
        {
            return new Integer(getClassesId());
        }
        if (name.equals("KechengId"))
        {
            return new Integer(getKechengId());
        }
        if (name.equals("KechengStart"))
        {
            return getKechengStart();
        }
        if (name.equals("KechengEnd"))
        {
            return getKechengEnd();
        }
        if (name.equals("Week"))
        {
            return new Integer(getWeek());
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
        if (name.equals("ClassesId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setClassesId(((Integer) value).intValue());
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
        if (name.equals("KechengStart"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setKechengStart((Date) value);
            return true;
        }
        if (name.equals("KechengEnd"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setKechengEnd((Date) value);
            return true;
        }
        if (name.equals("Week"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setWeek(((Integer) value).intValue());
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
        if (name.equals(ClassesKechengPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(ClassesKechengPeer.CLASSES_ID))
        {
            return new Integer(getClassesId());
        }
        if (name.equals(ClassesKechengPeer.KECHENG_ID))
        {
            return new Integer(getKechengId());
        }
        if (name.equals(ClassesKechengPeer.KECHENG_START))
        {
            return getKechengStart();
        }
        if (name.equals(ClassesKechengPeer.KECHENG_END))
        {
            return getKechengEnd();
        }
        if (name.equals(ClassesKechengPeer.WEEK))
        {
            return new Integer(getWeek());
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
      if (ClassesKechengPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (ClassesKechengPeer.CLASSES_ID.equals(name))
        {
            return setByName("ClassesId", value);
        }
      if (ClassesKechengPeer.KECHENG_ID.equals(name))
        {
            return setByName("KechengId", value);
        }
      if (ClassesKechengPeer.KECHENG_START.equals(name))
        {
            return setByName("KechengStart", value);
        }
      if (ClassesKechengPeer.KECHENG_END.equals(name))
        {
            return setByName("KechengEnd", value);
        }
      if (ClassesKechengPeer.WEEK.equals(name))
        {
            return setByName("Week", value);
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
            return new Integer(getClassesId());
        }
        if (pos == 2)
        {
            return new Integer(getKechengId());
        }
        if (pos == 3)
        {
            return getKechengStart();
        }
        if (pos == 4)
        {
            return getKechengEnd();
        }
        if (pos == 5)
        {
            return new Integer(getWeek());
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
            return setByName("ClassesId", value);
        }
    if (position == 2)
        {
            return setByName("KechengId", value);
        }
    if (position == 3)
        {
            return setByName("KechengStart", value);
        }
    if (position == 4)
        {
            return setByName("KechengEnd", value);
        }
    if (position == 5)
        {
            return setByName("Week", value);
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
        save(ClassesKechengPeer.DATABASE_NAME);
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
                    ClassesKechengPeer.doInsert((ClassesKecheng) this, con);
                    setNew(false);
                }
                else
                {
                    ClassesKechengPeer.doUpdate((ClassesKecheng) this, con);
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
    public ClassesKecheng copy() throws TorqueException
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
    public ClassesKecheng copy(Connection con) throws TorqueException
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
    public ClassesKecheng copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new ClassesKecheng(), deepcopy);
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
    public ClassesKecheng copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new ClassesKecheng(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected ClassesKecheng copyInto(ClassesKecheng copyObj) throws TorqueException
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
    protected ClassesKecheng copyInto(ClassesKecheng copyObj, Connection con) throws TorqueException
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
    protected ClassesKecheng copyInto(ClassesKecheng copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setClassesId(classesId);
        copyObj.setKechengId(kechengId);
        copyObj.setKechengStart(kechengStart);
        copyObj.setKechengEnd(kechengEnd);
        copyObj.setWeek(week);

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
    protected ClassesKecheng copyInto(ClassesKecheng copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setClassesId(classesId);
        copyObj.setKechengId(kechengId);
        copyObj.setKechengStart(kechengStart);
        copyObj.setKechengEnd(kechengEnd);
        copyObj.setWeek(week);

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
    public ClassesKechengPeer getPeer()
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
        return ClassesKechengPeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("ClassesKecheng:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("ClassesId = ")
           .append(getClassesId())
           .append("\n");
        str.append("KechengId = ")
           .append(getKechengId())
           .append("\n");
        str.append("KechengStart = ")
           .append(getKechengStart())
           .append("\n");
        str.append("KechengEnd = ")
           .append(getKechengEnd())
           .append("\n");
        str.append("Week = ")
           .append(getWeek())
           .append("\n");
        return(str.toString());
    }
}
