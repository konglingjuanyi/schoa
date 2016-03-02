package com.hao.schoa.po;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.torque.TorqueException;
import org.apache.torque.map.TableMap;
import org.apache.torque.om.BaseObject;
import org.apache.torque.om.NumberKey;
import org.apache.torque.om.ObjectKey;
import org.apache.torque.om.SimpleKey;
import org.apache.torque.util.Transaction;





/**
 * You should not use this class directly.  It should not even be
 * extended all references should be to ClassesStudent
 */
public abstract class BaseClassesStudent extends BaseObject
{
    /** The Peer class */
    private static final ClassesStudentPeer peer =
        new ClassesStudentPeer();


    /** The value for the id field */
    private int id;

    /** The value for the classesId field */
    private int classesId = 0;

    /** The value for the studentId field */
    private int studentId = 0;

    /** The value for the xueqiId field */
    private int xueqiId = 0;

    /** The value for the youxiu field */
    private int youxiu = 0;

    /** The value for the jinbu field */
    private int jinbu;


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
            fieldNames.add("StudentId");
            fieldNames.add("XueqiId");
            fieldNames.add("Youxiu");
            fieldNames.add("Jinbu");
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
        if (name.equals("StudentId"))
        {
            return new Integer(getStudentId());
        }
        if (name.equals("XueqiId"))
        {
            return new Integer(getXueqiId());
        }
        if (name.equals("Youxiu"))
        {
            return new Integer(getYouxiu());
        }
        if (name.equals("Jinbu"))
        {
            return new Integer(getJinbu());
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
        if (name.equals("StudentId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setStudentId(((Integer) value).intValue());
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
        if (name.equals("Youxiu"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setYouxiu(((Integer) value).intValue());
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
        if (name.equals(ClassesStudentPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(ClassesStudentPeer.CLASSES_ID))
        {
            return new Integer(getClassesId());
        }
        if (name.equals(ClassesStudentPeer.STUDENT_ID))
        {
            return new Integer(getStudentId());
        }
        if (name.equals(ClassesStudentPeer.XUEQI_ID))
        {
            return new Integer(getXueqiId());
        }
        if (name.equals(ClassesStudentPeer.YOUXIU))
        {
            return new Integer(getYouxiu());
        }
        if (name.equals(ClassesStudentPeer.JINBU))
        {
            return new Integer(getJinbu());
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
      if (ClassesStudentPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (ClassesStudentPeer.CLASSES_ID.equals(name))
        {
            return setByName("ClassesId", value);
        }
      if (ClassesStudentPeer.STUDENT_ID.equals(name))
        {
            return setByName("StudentId", value);
        }
      if (ClassesStudentPeer.XUEQI_ID.equals(name))
        {
            return setByName("XueqiId", value);
        }
      if (ClassesStudentPeer.YOUXIU.equals(name))
        {
            return setByName("Youxiu", value);
        }
      if (ClassesStudentPeer.JINBU.equals(name))
        {
            return setByName("Jinbu", value);
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
            return new Integer(getStudentId());
        }
        if (pos == 3)
        {
            return new Integer(getXueqiId());
        }
        if (pos == 4)
        {
            return new Integer(getYouxiu());
        }
        if (pos == 5)
        {
            return new Integer(getJinbu());
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
            return setByName("StudentId", value);
        }
    if (position == 3)
        {
            return setByName("XueqiId", value);
        }
    if (position == 4)
        {
            return setByName("Youxiu", value);
        }
    if (position == 5)
        {
            return setByName("Jinbu", value);
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
        save(ClassesStudentPeer.DATABASE_NAME);
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
                    ClassesStudentPeer.doInsert((ClassesStudent) this, con);
                    setNew(false);
                }
                else
                {
                    ClassesStudentPeer.doUpdate((ClassesStudent) this, con);
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
    public ClassesStudent copy() throws TorqueException
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
    public ClassesStudent copy(Connection con) throws TorqueException
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
    public ClassesStudent copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new ClassesStudent(), deepcopy);
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
    public ClassesStudent copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new ClassesStudent(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected ClassesStudent copyInto(ClassesStudent copyObj) throws TorqueException
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
    protected ClassesStudent copyInto(ClassesStudent copyObj, Connection con) throws TorqueException
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
    protected ClassesStudent copyInto(ClassesStudent copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setClassesId(classesId);
        copyObj.setStudentId(studentId);
        copyObj.setXueqiId(xueqiId);
        copyObj.setYouxiu(youxiu);
        copyObj.setJinbu(jinbu);

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
    protected ClassesStudent copyInto(ClassesStudent copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setClassesId(classesId);
        copyObj.setStudentId(studentId);
        copyObj.setXueqiId(xueqiId);
        copyObj.setYouxiu(youxiu);
        copyObj.setJinbu(jinbu);

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
    public ClassesStudentPeer getPeer()
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
        return ClassesStudentPeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("ClassesStudent:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("ClassesId = ")
           .append(getClassesId())
           .append("\n");
        str.append("StudentId = ")
           .append(getStudentId())
           .append("\n");
        str.append("XueqiId = ")
           .append(getXueqiId())
           .append("\n");
        str.append("Youxiu = ")
           .append(getYouxiu())
           .append("\n");
        str.append("Jinbu = ")
           .append(getJinbu())
           .append("\n");
        return(str.toString());
    }
}
