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
 * extended all references should be to Member
 */
public abstract class BaseMember extends BaseObject
{
    /** The Peer class */
    private static final MemberPeer peer =
        new MemberPeer();


    /** The value for the id field */
    private int id;

    /** The value for the name field */
    private String name;

    /** The value for the valid field */
    private int valid = 0;

    /** The value for the pwd field */
    private String pwd;

    /** The value for the showName field */
    private String showName;

    /** The value for the roleId field */
    private int roleId;

    /** The value for the phone field */
    private String phone;

    /** The value for the email field */
    private String email;

    /** The value for the teacherId field */
    private int teacherId = 0;


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
     * Get the Valid
     *
     * @return int
     */
    public int getValid()
    {
        return valid;
    }


    /**
     * Set the value of Valid
     *
     * @param v new value
     */
    public void setValid(int v) 
    {

        if (this.valid != v)
        {
            this.valid = v;
            setModified(true);
        }


    }

    /**
     * Get the Pwd
     *
     * @return String
     */
    public String getPwd()
    {
        return pwd;
    }


    /**
     * Set the value of Pwd
     *
     * @param v new value
     */
    public void setPwd(String v) 
    {

        if (!ObjectUtils.equals(this.pwd, v))
        {
            this.pwd = v;
            setModified(true);
        }


    }

    /**
     * Get the ShowName
     *
     * @return String
     */
    public String getShowName()
    {
        return showName;
    }


    /**
     * Set the value of ShowName
     *
     * @param v new value
     */
    public void setShowName(String v) 
    {

        if (!ObjectUtils.equals(this.showName, v))
        {
            this.showName = v;
            setModified(true);
        }


    }

    /**
     * Get the RoleId
     *
     * @return int
     */
    public int getRoleId()
    {
        return roleId;
    }


    /**
     * Set the value of RoleId
     *
     * @param v new value
     */
    public void setRoleId(int v) 
    {

        if (this.roleId != v)
        {
            this.roleId = v;
            setModified(true);
        }


    }

    /**
     * Get the Phone
     *
     * @return String
     */
    public String getPhone()
    {
        return phone;
    }


    /**
     * Set the value of Phone
     *
     * @param v new value
     */
    public void setPhone(String v) 
    {

        if (!ObjectUtils.equals(this.phone, v))
        {
            this.phone = v;
            setModified(true);
        }


    }

    /**
     * Get the Email
     *
     * @return String
     */
    public String getEmail()
    {
        return email;
    }


    /**
     * Set the value of Email
     *
     * @param v new value
     */
    public void setEmail(String v) 
    {

        if (!ObjectUtils.equals(this.email, v))
        {
            this.email = v;
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
            fieldNames.add("Valid");
            fieldNames.add("Pwd");
            fieldNames.add("ShowName");
            fieldNames.add("RoleId");
            fieldNames.add("Phone");
            fieldNames.add("Email");
            fieldNames.add("TeacherId");
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
        if (name.equals("Valid"))
        {
            return new Integer(getValid());
        }
        if (name.equals("Pwd"))
        {
            return getPwd();
        }
        if (name.equals("ShowName"))
        {
            return getShowName();
        }
        if (name.equals("RoleId"))
        {
            return new Integer(getRoleId());
        }
        if (name.equals("Phone"))
        {
            return getPhone();
        }
        if (name.equals("Email"))
        {
            return getEmail();
        }
        if (name.equals("TeacherId"))
        {
            return new Integer(getTeacherId());
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
        if (name.equals("Valid"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setValid(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Pwd"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setPwd((String) value);
            return true;
        }
        if (name.equals("ShowName"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setShowName((String) value);
            return true;
        }
        if (name.equals("RoleId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setRoleId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Phone"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setPhone((String) value);
            return true;
        }
        if (name.equals("Email"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setEmail((String) value);
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
        if (name.equals(MemberPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(MemberPeer.NAME))
        {
            return getName();
        }
        if (name.equals(MemberPeer.VALID))
        {
            return new Integer(getValid());
        }
        if (name.equals(MemberPeer.PWD))
        {
            return getPwd();
        }
        if (name.equals(MemberPeer.SHOW_NAME))
        {
            return getShowName();
        }
        if (name.equals(MemberPeer.ROLE_ID))
        {
            return new Integer(getRoleId());
        }
        if (name.equals(MemberPeer.PHONE))
        {
            return getPhone();
        }
        if (name.equals(MemberPeer.EMAIL))
        {
            return getEmail();
        }
        if (name.equals(MemberPeer.TEACHER_ID))
        {
            return new Integer(getTeacherId());
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
      if (MemberPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (MemberPeer.NAME.equals(name))
        {
            return setByName("Name", value);
        }
      if (MemberPeer.VALID.equals(name))
        {
            return setByName("Valid", value);
        }
      if (MemberPeer.PWD.equals(name))
        {
            return setByName("Pwd", value);
        }
      if (MemberPeer.SHOW_NAME.equals(name))
        {
            return setByName("ShowName", value);
        }
      if (MemberPeer.ROLE_ID.equals(name))
        {
            return setByName("RoleId", value);
        }
      if (MemberPeer.PHONE.equals(name))
        {
            return setByName("Phone", value);
        }
      if (MemberPeer.EMAIL.equals(name))
        {
            return setByName("Email", value);
        }
      if (MemberPeer.TEACHER_ID.equals(name))
        {
            return setByName("TeacherId", value);
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
            return new Integer(getValid());
        }
        if (pos == 3)
        {
            return getPwd();
        }
        if (pos == 4)
        {
            return getShowName();
        }
        if (pos == 5)
        {
            return new Integer(getRoleId());
        }
        if (pos == 6)
        {
            return getPhone();
        }
        if (pos == 7)
        {
            return getEmail();
        }
        if (pos == 8)
        {
            return new Integer(getTeacherId());
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
            return setByName("Valid", value);
        }
    if (position == 3)
        {
            return setByName("Pwd", value);
        }
    if (position == 4)
        {
            return setByName("ShowName", value);
        }
    if (position == 5)
        {
            return setByName("RoleId", value);
        }
    if (position == 6)
        {
            return setByName("Phone", value);
        }
    if (position == 7)
        {
            return setByName("Email", value);
        }
    if (position == 8)
        {
            return setByName("TeacherId", value);
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
        save(MemberPeer.DATABASE_NAME);
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
                    MemberPeer.doInsert((Member) this, con);
                    setNew(false);
                }
                else
                {
                    MemberPeer.doUpdate((Member) this, con);
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
    public Member copy() throws TorqueException
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
    public Member copy(Connection con) throws TorqueException
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
    public Member copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new Member(), deepcopy);
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
    public Member copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new Member(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected Member copyInto(Member copyObj) throws TorqueException
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
    protected Member copyInto(Member copyObj, Connection con) throws TorqueException
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
    protected Member copyInto(Member copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setName(name);
        copyObj.setValid(valid);
        copyObj.setPwd(pwd);
        copyObj.setShowName(showName);
        copyObj.setRoleId(roleId);
        copyObj.setPhone(phone);
        copyObj.setEmail(email);
        copyObj.setTeacherId(teacherId);

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
    protected Member copyInto(Member copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setName(name);
        copyObj.setValid(valid);
        copyObj.setPwd(pwd);
        copyObj.setShowName(showName);
        copyObj.setRoleId(roleId);
        copyObj.setPhone(phone);
        copyObj.setEmail(email);
        copyObj.setTeacherId(teacherId);

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
    public MemberPeer getPeer()
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
        return MemberPeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("Member:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("Name = ")
           .append(getName())
           .append("\n");
        str.append("Valid = ")
           .append(getValid())
           .append("\n");
        str.append("Pwd = ")
           .append(getPwd())
           .append("\n");
        str.append("ShowName = ")
           .append(getShowName())
           .append("\n");
        str.append("RoleId = ")
           .append(getRoleId())
           .append("\n");
        str.append("Phone = ")
           .append(getPhone())
           .append("\n");
        str.append("Email = ")
           .append(getEmail())
           .append("\n");
        str.append("TeacherId = ")
           .append(getTeacherId())
           .append("\n");
        return(str.toString());
    }
}
