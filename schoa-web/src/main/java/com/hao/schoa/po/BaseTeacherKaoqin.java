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
 * extended all references should be to TeacherKaoqin
 */
public abstract class BaseTeacherKaoqin extends BaseObject
{
    /** The Peer class */
    private static final TeacherKaoqinPeer peer =
        new TeacherKaoqinPeer();


    /** The value for the id field */
    private int id;

    /** The value for the classesKechengId field */
    private int classesKechengId = 0;

    /** The value for the teacherId field */
    private int teacherId = 0;

    /** The value for the kaoqin field */
    private int kaoqin = 0;

    /** The value for the kaoqinRemark field */
    private String kaoqinRemark = "0";

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
     * Get the KaoqinRemark
     *
     * @return String
     */
    public String getKaoqinRemark()
    {
        return kaoqinRemark;
    }


    /**
     * Set the value of KaoqinRemark
     *
     * @param v new value
     */
    public void setKaoqinRemark(String v) 
    {

        if (!ObjectUtils.equals(this.kaoqinRemark, v))
        {
            this.kaoqinRemark = v;
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
            fieldNames.add("TeacherId");
            fieldNames.add("Kaoqin");
            fieldNames.add("KaoqinRemark");
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
        if (name.equals("TeacherId"))
        {
            return new Integer(getTeacherId());
        }
        if (name.equals("Kaoqin"))
        {
            return new Integer(getKaoqin());
        }
        if (name.equals("KaoqinRemark"))
        {
            return getKaoqinRemark();
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
        if (name.equals("TeacherId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setTeacherId(((Integer) value).intValue());
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
        if (name.equals("KaoqinRemark"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setKaoqinRemark((String) value);
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
        if (name.equals(TeacherKaoqinPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(TeacherKaoqinPeer.CLASSES_KECHENG_ID))
        {
            return new Integer(getClassesKechengId());
        }
        if (name.equals(TeacherKaoqinPeer.TEACHER_ID))
        {
            return new Integer(getTeacherId());
        }
        if (name.equals(TeacherKaoqinPeer.KAOQIN))
        {
            return new Integer(getKaoqin());
        }
        if (name.equals(TeacherKaoqinPeer.KAOQIN_REMARK))
        {
            return getKaoqinRemark();
        }
        if (name.equals(TeacherKaoqinPeer.DAY))
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
      if (TeacherKaoqinPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (TeacherKaoqinPeer.CLASSES_KECHENG_ID.equals(name))
        {
            return setByName("ClassesKechengId", value);
        }
      if (TeacherKaoqinPeer.TEACHER_ID.equals(name))
        {
            return setByName("TeacherId", value);
        }
      if (TeacherKaoqinPeer.KAOQIN.equals(name))
        {
            return setByName("Kaoqin", value);
        }
      if (TeacherKaoqinPeer.KAOQIN_REMARK.equals(name))
        {
            return setByName("KaoqinRemark", value);
        }
      if (TeacherKaoqinPeer.DAY.equals(name))
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
            return new Integer(getTeacherId());
        }
        if (pos == 3)
        {
            return new Integer(getKaoqin());
        }
        if (pos == 4)
        {
            return getKaoqinRemark();
        }
        if (pos == 5)
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
            return setByName("TeacherId", value);
        }
    if (position == 3)
        {
            return setByName("Kaoqin", value);
        }
    if (position == 4)
        {
            return setByName("KaoqinRemark", value);
        }
    if (position == 5)
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
        save(TeacherKaoqinPeer.DATABASE_NAME);
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
                    TeacherKaoqinPeer.doInsert((TeacherKaoqin) this, con);
                    setNew(false);
                }
                else
                {
                    TeacherKaoqinPeer.doUpdate((TeacherKaoqin) this, con);
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
    public TeacherKaoqin copy() throws TorqueException
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
    public TeacherKaoqin copy(Connection con) throws TorqueException
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
    public TeacherKaoqin copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new TeacherKaoqin(), deepcopy);
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
    public TeacherKaoqin copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new TeacherKaoqin(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected TeacherKaoqin copyInto(TeacherKaoqin copyObj) throws TorqueException
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
    protected TeacherKaoqin copyInto(TeacherKaoqin copyObj, Connection con) throws TorqueException
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
    protected TeacherKaoqin copyInto(TeacherKaoqin copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setClassesKechengId(classesKechengId);
        copyObj.setTeacherId(teacherId);
        copyObj.setKaoqin(kaoqin);
        copyObj.setKaoqinRemark(kaoqinRemark);
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
    protected TeacherKaoqin copyInto(TeacherKaoqin copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setClassesKechengId(classesKechengId);
        copyObj.setTeacherId(teacherId);
        copyObj.setKaoqin(kaoqin);
        copyObj.setKaoqinRemark(kaoqinRemark);
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
    public TeacherKaoqinPeer getPeer()
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
        return TeacherKaoqinPeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("TeacherKaoqin:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("ClassesKechengId = ")
           .append(getClassesKechengId())
           .append("\n");
        str.append("TeacherId = ")
           .append(getTeacherId())
           .append("\n");
        str.append("Kaoqin = ")
           .append(getKaoqin())
           .append("\n");
        str.append("KaoqinRemark = ")
           .append(getKaoqinRemark())
           .append("\n");
        str.append("Day = ")
           .append(getDay())
           .append("\n");
        return(str.toString());
    }
}
