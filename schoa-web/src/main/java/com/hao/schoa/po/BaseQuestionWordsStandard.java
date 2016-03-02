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
 * extended all references should be to QuestionWordsStandard
 */
public abstract class BaseQuestionWordsStandard extends BaseObject
{
    /** The Peer class */
    private static final QuestionWordsStandardPeer peer =
        new QuestionWordsStandardPeer();


    /** The value for the id field */
    private int id;

    /** The value for the name field */
    private String name;

    /** The value for the directions field */
    private String directions;

    /** The value for the createTime field */
    private Date createTime;

    /** The value for the createMemberId field */
    private int createMemberId = 0;

    /** The value for the createMember field */
    private String createMember;

    /** The value for the modifyTime field */
    private Date modifyTime;

    /** The value for the modifyMemberId field */
    private int modifyMemberId = 0;

    /** The value for the modifyMember field */
    private String modifyMember;


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
     * Get the Directions
     *
     * @return String
     */
    public String getDirections()
    {
        return directions;
    }


    /**
     * Set the value of Directions
     *
     * @param v new value
     */
    public void setDirections(String v) 
    {

        if (!ObjectUtils.equals(this.directions, v))
        {
            this.directions = v;
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
     * Get the CreateMemberId
     *
     * @return int
     */
    public int getCreateMemberId()
    {
        return createMemberId;
    }


    /**
     * Set the value of CreateMemberId
     *
     * @param v new value
     */
    public void setCreateMemberId(int v) 
    {

        if (this.createMemberId != v)
        {
            this.createMemberId = v;
            setModified(true);
        }


    }

    /**
     * Get the CreateMember
     *
     * @return String
     */
    public String getCreateMember()
    {
        return createMember;
    }


    /**
     * Set the value of CreateMember
     *
     * @param v new value
     */
    public void setCreateMember(String v) 
    {

        if (!ObjectUtils.equals(this.createMember, v))
        {
            this.createMember = v;
            setModified(true);
        }


    }

    /**
     * Get the ModifyTime
     *
     * @return Date
     */
    public Date getModifyTime()
    {
        return modifyTime;
    }


    /**
     * Set the value of ModifyTime
     *
     * @param v new value
     */
    public void setModifyTime(Date v) 
    {

        if (!ObjectUtils.equals(this.modifyTime, v))
        {
            this.modifyTime = v;
            setModified(true);
        }


    }

    /**
     * Get the ModifyMemberId
     *
     * @return int
     */
    public int getModifyMemberId()
    {
        return modifyMemberId;
    }


    /**
     * Set the value of ModifyMemberId
     *
     * @param v new value
     */
    public void setModifyMemberId(int v) 
    {

        if (this.modifyMemberId != v)
        {
            this.modifyMemberId = v;
            setModified(true);
        }


    }

    /**
     * Get the ModifyMember
     *
     * @return String
     */
    public String getModifyMember()
    {
        return modifyMember;
    }


    /**
     * Set the value of ModifyMember
     *
     * @param v new value
     */
    public void setModifyMember(String v) 
    {

        if (!ObjectUtils.equals(this.modifyMember, v))
        {
            this.modifyMember = v;
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
            fieldNames.add("Directions");
            fieldNames.add("CreateTime");
            fieldNames.add("CreateMemberId");
            fieldNames.add("CreateMember");
            fieldNames.add("ModifyTime");
            fieldNames.add("ModifyMemberId");
            fieldNames.add("ModifyMember");
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
        if (name.equals("Directions"))
        {
            return getDirections();
        }
        if (name.equals("CreateTime"))
        {
            return getCreateTime();
        }
        if (name.equals("CreateMemberId"))
        {
            return new Integer(getCreateMemberId());
        }
        if (name.equals("CreateMember"))
        {
            return getCreateMember();
        }
        if (name.equals("ModifyTime"))
        {
            return getModifyTime();
        }
        if (name.equals("ModifyMemberId"))
        {
            return new Integer(getModifyMemberId());
        }
        if (name.equals("ModifyMember"))
        {
            return getModifyMember();
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
        if (name.equals("Directions"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setDirections((String) value);
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
        if (name.equals("CreateMemberId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCreateMemberId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("CreateMember"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setCreateMember((String) value);
            return true;
        }
        if (name.equals("ModifyTime"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setModifyTime((Date) value);
            return true;
        }
        if (name.equals("ModifyMemberId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setModifyMemberId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("ModifyMember"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setModifyMember((String) value);
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
        if (name.equals(QuestionWordsStandardPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(QuestionWordsStandardPeer.NAME))
        {
            return getName();
        }
        if (name.equals(QuestionWordsStandardPeer.DIRECTIONS))
        {
            return getDirections();
        }
        if (name.equals(QuestionWordsStandardPeer.CREATE_TIME))
        {
            return getCreateTime();
        }
        if (name.equals(QuestionWordsStandardPeer.CREATE_MEMBER_ID))
        {
            return new Integer(getCreateMemberId());
        }
        if (name.equals(QuestionWordsStandardPeer.CREATE_MEMBER))
        {
            return getCreateMember();
        }
        if (name.equals(QuestionWordsStandardPeer.MODIFY_TIME))
        {
            return getModifyTime();
        }
        if (name.equals(QuestionWordsStandardPeer.MODIFY_MEMBER_ID))
        {
            return new Integer(getModifyMemberId());
        }
        if (name.equals(QuestionWordsStandardPeer.MODIFY_MEMBER))
        {
            return getModifyMember();
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
      if (QuestionWordsStandardPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (QuestionWordsStandardPeer.NAME.equals(name))
        {
            return setByName("Name", value);
        }
      if (QuestionWordsStandardPeer.DIRECTIONS.equals(name))
        {
            return setByName("Directions", value);
        }
      if (QuestionWordsStandardPeer.CREATE_TIME.equals(name))
        {
            return setByName("CreateTime", value);
        }
      if (QuestionWordsStandardPeer.CREATE_MEMBER_ID.equals(name))
        {
            return setByName("CreateMemberId", value);
        }
      if (QuestionWordsStandardPeer.CREATE_MEMBER.equals(name))
        {
            return setByName("CreateMember", value);
        }
      if (QuestionWordsStandardPeer.MODIFY_TIME.equals(name))
        {
            return setByName("ModifyTime", value);
        }
      if (QuestionWordsStandardPeer.MODIFY_MEMBER_ID.equals(name))
        {
            return setByName("ModifyMemberId", value);
        }
      if (QuestionWordsStandardPeer.MODIFY_MEMBER.equals(name))
        {
            return setByName("ModifyMember", value);
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
            return getDirections();
        }
        if (pos == 3)
        {
            return getCreateTime();
        }
        if (pos == 4)
        {
            return new Integer(getCreateMemberId());
        }
        if (pos == 5)
        {
            return getCreateMember();
        }
        if (pos == 6)
        {
            return getModifyTime();
        }
        if (pos == 7)
        {
            return new Integer(getModifyMemberId());
        }
        if (pos == 8)
        {
            return getModifyMember();
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
            return setByName("Directions", value);
        }
    if (position == 3)
        {
            return setByName("CreateTime", value);
        }
    if (position == 4)
        {
            return setByName("CreateMemberId", value);
        }
    if (position == 5)
        {
            return setByName("CreateMember", value);
        }
    if (position == 6)
        {
            return setByName("ModifyTime", value);
        }
    if (position == 7)
        {
            return setByName("ModifyMemberId", value);
        }
    if (position == 8)
        {
            return setByName("ModifyMember", value);
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
        save(QuestionWordsStandardPeer.DATABASE_NAME);
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
                    QuestionWordsStandardPeer.doInsert((QuestionWordsStandard) this, con);
                    setNew(false);
                }
                else
                {
                    QuestionWordsStandardPeer.doUpdate((QuestionWordsStandard) this, con);
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
    public QuestionWordsStandard copy() throws TorqueException
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
    public QuestionWordsStandard copy(Connection con) throws TorqueException
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
    public QuestionWordsStandard copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new QuestionWordsStandard(), deepcopy);
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
    public QuestionWordsStandard copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new QuestionWordsStandard(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected QuestionWordsStandard copyInto(QuestionWordsStandard copyObj) throws TorqueException
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
    protected QuestionWordsStandard copyInto(QuestionWordsStandard copyObj, Connection con) throws TorqueException
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
    protected QuestionWordsStandard copyInto(QuestionWordsStandard copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setName(name);
        copyObj.setDirections(directions);
        copyObj.setCreateTime(createTime);
        copyObj.setCreateMemberId(createMemberId);
        copyObj.setCreateMember(createMember);
        copyObj.setModifyTime(modifyTime);
        copyObj.setModifyMemberId(modifyMemberId);
        copyObj.setModifyMember(modifyMember);

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
    protected QuestionWordsStandard copyInto(QuestionWordsStandard copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setName(name);
        copyObj.setDirections(directions);
        copyObj.setCreateTime(createTime);
        copyObj.setCreateMemberId(createMemberId);
        copyObj.setCreateMember(createMember);
        copyObj.setModifyTime(modifyTime);
        copyObj.setModifyMemberId(modifyMemberId);
        copyObj.setModifyMember(modifyMember);

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
    public QuestionWordsStandardPeer getPeer()
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
        return QuestionWordsStandardPeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("QuestionWordsStandard:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("Name = ")
           .append(getName())
           .append("\n");
        str.append("Directions = ")
           .append(getDirections())
           .append("\n");
        str.append("CreateTime = ")
           .append(getCreateTime())
           .append("\n");
        str.append("CreateMemberId = ")
           .append(getCreateMemberId())
           .append("\n");
        str.append("CreateMember = ")
           .append(getCreateMember())
           .append("\n");
        str.append("ModifyTime = ")
           .append(getModifyTime())
           .append("\n");
        str.append("ModifyMemberId = ")
           .append(getModifyMemberId())
           .append("\n");
        str.append("ModifyMember = ")
           .append(getModifyMember())
           .append("\n");
        return(str.toString());
    }
}
