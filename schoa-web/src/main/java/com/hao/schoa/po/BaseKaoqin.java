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
 * extended all references should be to Kaoqin
 */
public abstract class BaseKaoqin extends BaseObject
{
    /** The Peer class */
    private static final KaoqinPeer peer =
        new KaoqinPeer();


    /** The value for the id field */
    private int id;

    /** The value for the classesKechengId field */
    private int classesKechengId = 0;

    /** The value for the studentId field */
    private int studentId = 0;

    /** The value for the kaoqin field */
    private int kaoqin = 0;

    /** The value for the day field */
    private Date day = new Date(0000-00-00);


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
     * Get the ClassesKechengId
     *
     * @return int
     */
    public int getClassesKechengId()
    {
        return classesKechengId;
    }


    /**
     * Set the value of ClassesKechengId
     *
     * @param v new value
     */
    public void setClassesKechengId(int v) 
    {

        if (this.classesKechengId != v)
        {
            this.classesKechengId = v;
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
     * Get the Kaoqin
     *
     * @return int
     */
    public int getKaoqin()
    {
        return kaoqin;
    }


    /**
     * Set the value of Kaoqin
     *
     * @param v new value
     */
    public void setKaoqin(int v) 
    {

        if (this.kaoqin != v)
        {
            this.kaoqin = v;
            setModified(true);
        }


    }

    /**
     * Get the Day
     *
     * @return Date
     */
    public Date getDay()
    {
        return day;
    }


    /**
     * Set the value of Day
     *
     * @param v new value
     */
    public void setDay(Date v) 
    {

        if (!ObjectUtils.equals(this.day, v))
        {
            this.day = v;
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
            fieldNames.add("ClassesKechengId");
            fieldNames.add("StudentId");
            fieldNames.add("Kaoqin");
            fieldNames.add("Day");
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
        if (name.equals("ClassesKechengId"))
        {
            return new Integer(getClassesKechengId());
        }
        if (name.equals("StudentId"))
        {
            return new Integer(getStudentId());
        }
        if (name.equals("Kaoqin"))
        {
            return new Integer(getKaoqin());
        }
        if (name.equals("Day"))
        {
            return getDay();
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
        if (name.equals("ClassesKechengId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setClassesKechengId(((Integer) value).intValue());
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
        if (name.equals("Kaoqin"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setKaoqin(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Day"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setDay((Date) value);
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
        if (name.equals(KaoqinPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(KaoqinPeer.CLASSES_KECHENG_ID))
        {
            return new Integer(getClassesKechengId());
        }
        if (name.equals(KaoqinPeer.STUDENT_ID))
        {
            return new Integer(getStudentId());
        }
        if (name.equals(KaoqinPeer.KAOQIN))
        {
            return new Integer(getKaoqin());
        }
        if (name.equals(KaoqinPeer.DAY))
        {
            return getDay();
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
      if (KaoqinPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (KaoqinPeer.CLASSES_KECHENG_ID.equals(name))
        {
            return setByName("ClassesKechengId", value);
        }
      if (KaoqinPeer.STUDENT_ID.equals(name))
        {
            return setByName("StudentId", value);
        }
      if (KaoqinPeer.KAOQIN.equals(name))
        {
            return setByName("Kaoqin", value);
        }
      if (KaoqinPeer.DAY.equals(name))
        {
            return setByName("Day", value);
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
            return new Integer(getClassesKechengId());
        }
        if (pos == 2)
        {
            return new Integer(getStudentId());
        }
        if (pos == 3)
        {
            return new Integer(getKaoqin());
        }
        if (pos == 4)
        {
            return getDay();
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
            return setByName("ClassesKechengId", value);
        }
    if (position == 2)
        {
            return setByName("StudentId", value);
        }
    if (position == 3)
        {
            return setByName("Kaoqin", value);
        }
    if (position == 4)
        {
            return setByName("Day", value);
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
        save(KaoqinPeer.DATABASE_NAME);
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
                    KaoqinPeer.doInsert((Kaoqin) this, con);
                    setNew(false);
                }
                else
                {
                    KaoqinPeer.doUpdate((Kaoqin) this, con);
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
    public Kaoqin copy() throws TorqueException
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
    public Kaoqin copy(Connection con) throws TorqueException
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
    public Kaoqin copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new Kaoqin(), deepcopy);
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
    public Kaoqin copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new Kaoqin(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected Kaoqin copyInto(Kaoqin copyObj) throws TorqueException
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
    protected Kaoqin copyInto(Kaoqin copyObj, Connection con) throws TorqueException
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
    protected Kaoqin copyInto(Kaoqin copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setClassesKechengId(classesKechengId);
        copyObj.setStudentId(studentId);
        copyObj.setKaoqin(kaoqin);
        copyObj.setDay(day);

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
    protected Kaoqin copyInto(Kaoqin copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setClassesKechengId(classesKechengId);
        copyObj.setStudentId(studentId);
        copyObj.setKaoqin(kaoqin);
        copyObj.setDay(day);

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
    public KaoqinPeer getPeer()
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
        return KaoqinPeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("Kaoqin:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("ClassesKechengId = ")
           .append(getClassesKechengId())
           .append("\n");
        str.append("StudentId = ")
           .append(getStudentId())
           .append("\n");
        str.append("Kaoqin = ")
           .append(getKaoqin())
           .append("\n");
        str.append("Day = ")
           .append(getDay())
           .append("\n");
        return(str.toString());
    }
}
