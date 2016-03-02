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
 * extended all references should be to Country
 */
public abstract class BaseCountry extends BaseObject
{
    /** The Peer class */
    private static final CountryPeer peer =
        new CountryPeer();


    /** The value for the id field */
    private int id;

    /** The value for the ename field */
    private String ename;

    /** The value for the cname field */
    private String cname;

    /** The value for the path field */
    private String path;

    /** The value for the states field */
    private String states;


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
     * Get the Ename
     *
     * @return String
     */
    public String getEname()
    {
        return ename;
    }


    /**
     * Set the value of Ename
     *
     * @param v new value
     */
    public void setEname(String v) 
    {

        if (!ObjectUtils.equals(this.ename, v))
        {
            this.ename = v;
            setModified(true);
        }


    }

    /**
     * Get the Cname
     *
     * @return String
     */
    public String getCname()
    {
        return cname;
    }


    /**
     * Set the value of Cname
     *
     * @param v new value
     */
    public void setCname(String v) 
    {

        if (!ObjectUtils.equals(this.cname, v))
        {
            this.cname = v;
            setModified(true);
        }


    }

    /**
     * Get the Path
     *
     * @return String
     */
    public String getPath()
    {
        return path;
    }


    /**
     * Set the value of Path
     *
     * @param v new value
     */
    public void setPath(String v) 
    {

        if (!ObjectUtils.equals(this.path, v))
        {
            this.path = v;
            setModified(true);
        }


    }

    /**
     * Get the States
     *
     * @return String
     */
    public String getStates()
    {
        return states;
    }


    /**
     * Set the value of States
     *
     * @param v new value
     */
    public void setStates(String v) 
    {

        if (!ObjectUtils.equals(this.states, v))
        {
            this.states = v;
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
            fieldNames.add("Ename");
            fieldNames.add("Cname");
            fieldNames.add("Path");
            fieldNames.add("States");
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
        if (name.equals("Ename"))
        {
            return getEname();
        }
        if (name.equals("Cname"))
        {
            return getCname();
        }
        if (name.equals("Path"))
        {
            return getPath();
        }
        if (name.equals("States"))
        {
            return getStates();
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
        if (name.equals("Ename"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setEname((String) value);
            return true;
        }
        if (name.equals("Cname"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setCname((String) value);
            return true;
        }
        if (name.equals("Path"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setPath((String) value);
            return true;
        }
        if (name.equals("States"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setStates((String) value);
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
        if (name.equals(CountryPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(CountryPeer.ENAME))
        {
            return getEname();
        }
        if (name.equals(CountryPeer.CNAME))
        {
            return getCname();
        }
        if (name.equals(CountryPeer.PATH))
        {
            return getPath();
        }
        if (name.equals(CountryPeer.STATES))
        {
            return getStates();
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
      if (CountryPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (CountryPeer.ENAME.equals(name))
        {
            return setByName("Ename", value);
        }
      if (CountryPeer.CNAME.equals(name))
        {
            return setByName("Cname", value);
        }
      if (CountryPeer.PATH.equals(name))
        {
            return setByName("Path", value);
        }
      if (CountryPeer.STATES.equals(name))
        {
            return setByName("States", value);
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
            return getEname();
        }
        if (pos == 2)
        {
            return getCname();
        }
        if (pos == 3)
        {
            return getPath();
        }
        if (pos == 4)
        {
            return getStates();
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
            return setByName("Ename", value);
        }
    if (position == 2)
        {
            return setByName("Cname", value);
        }
    if (position == 3)
        {
            return setByName("Path", value);
        }
    if (position == 4)
        {
            return setByName("States", value);
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
        save(CountryPeer.DATABASE_NAME);
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
                    CountryPeer.doInsert((Country) this, con);
                    setNew(false);
                }
                else
                {
                    CountryPeer.doUpdate((Country) this, con);
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
    public Country copy() throws TorqueException
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
    public Country copy(Connection con) throws TorqueException
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
    public Country copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new Country(), deepcopy);
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
    public Country copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new Country(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected Country copyInto(Country copyObj) throws TorqueException
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
    protected Country copyInto(Country copyObj, Connection con) throws TorqueException
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
    protected Country copyInto(Country copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setEname(ename);
        copyObj.setCname(cname);
        copyObj.setPath(path);
        copyObj.setStates(states);

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
    protected Country copyInto(Country copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setEname(ename);
        copyObj.setCname(cname);
        copyObj.setPath(path);
        copyObj.setStates(states);

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
    public CountryPeer getPeer()
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
        return CountryPeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("Country:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("Ename = ")
           .append(getEname())
           .append("\n");
        str.append("Cname = ")
           .append(getCname())
           .append("\n");
        str.append("Path = ")
           .append(getPath())
           .append("\n");
        str.append("States = ")
           .append(getStates())
           .append("\n");
        return(str.toString());
    }
}
