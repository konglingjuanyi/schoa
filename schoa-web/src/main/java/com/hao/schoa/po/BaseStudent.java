package com.hao.schoa.po;


import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.torque.TorqueException;
import org.apache.torque.map.TableMap;
import org.apache.torque.om.BaseObject;
import org.apache.torque.om.ComboKey;
import org.apache.torque.om.DateKey;
import org.apache.torque.om.NumberKey;
import org.apache.torque.om.ObjectKey;
import org.apache.torque.om.SimpleKey;
import org.apache.torque.om.StringKey;
import org.apache.torque.om.Persistent;
import org.apache.torque.util.Criteria;
import org.apache.torque.util.Transaction;





/**
 * You should not use this class directly.  It should not even be
 * extended all references should be to Student
 */
public abstract class BaseStudent extends BaseObject
{
    /** The Peer class */
    private static final StudentPeer peer =
        new StudentPeer();


    /** The value for the id field */
    private int id;

    /** The value for the code field */
    private int code = 0;

    /** The value for the ename field */
    private String ename;

    /** The value for the cname field */
    private String cname;

    /** The value for the headPic field */
    private String headPic;

    /** The value for the sex field */
    private int sex = 0;

    /** The value for the passNumb field */
    private String passNumb;

    /** The value for the birthday field */
    private String birthday;

    /** The value for the nation field */
    private int nation = 0;

    /** The value for the address field */
    private String address;

    /** The value for the closedDate field */
    private Date closedDate;

    /** The value for the costFrom field */
    private int costFrom;

    /** The value for the phone field */
    private String phone;

    /** The value for the email field */
    private String email;

    /** The value for the state field */
    private int state = 0;

    /** The value for the stateUptime field */
    private Date stateUptime;

    /** The value for the stateIntro field */
    private String stateIntro;

    /** The value for the stuFrom field */
    private int stuFrom = 0;


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
     * Get the Code
     *
     * @return int
     */
    public int getCode()
    {
        return code;
    }


    /**
     * Set the value of Code
     *
     * @param v new value
     */
    public void setCode(int v) 
    {

        if (this.code != v)
        {
            this.code = v;
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
     * Get the HeadPic
     *
     * @return String
     */
    public String getHeadPic()
    {
        return headPic;
    }


    /**
     * Set the value of HeadPic
     *
     * @param v new value
     */
    public void setHeadPic(String v) 
    {

        if (!ObjectUtils.equals(this.headPic, v))
        {
            this.headPic = v;
            setModified(true);
        }


    }

    /**
     * Get the Sex
     *
     * @return int
     */
    public int getSex()
    {
        return sex;
    }


    /**
     * Set the value of Sex
     *
     * @param v new value
     */
    public void setSex(int v) 
    {

        if (this.sex != v)
        {
            this.sex = v;
            setModified(true);
        }


    }

    /**
     * Get the PassNumb
     *
     * @return String
     */
    public String getPassNumb()
    {
        return passNumb;
    }


    /**
     * Set the value of PassNumb
     *
     * @param v new value
     */
    public void setPassNumb(String v) 
    {

        if (!ObjectUtils.equals(this.passNumb, v))
        {
            this.passNumb = v;
            setModified(true);
        }


    }

    /**
     * Get the Birthday
     *
     * @return String
     */
    public String getBirthday()
    {
        return birthday;
    }


    /**
     * Set the value of Birthday
     *
     * @param v new value
     */
    public void setBirthday(String v) 
    {

        if (!ObjectUtils.equals(this.birthday, v))
        {
            this.birthday = v;
            setModified(true);
        }


    }

    /**
     * Get the Nation
     *
     * @return int
     */
    public int getNation()
    {
        return nation;
    }


    /**
     * Set the value of Nation
     *
     * @param v new value
     */
    public void setNation(int v) 
    {

        if (this.nation != v)
        {
            this.nation = v;
            setModified(true);
        }


    }

    /**
     * Get the Address
     *
     * @return String
     */
    public String getAddress()
    {
        return address;
    }


    /**
     * Set the value of Address
     *
     * @param v new value
     */
    public void setAddress(String v) 
    {

        if (!ObjectUtils.equals(this.address, v))
        {
            this.address = v;
            setModified(true);
        }


    }

    /**
     * Get the ClosedDate
     *
     * @return Date
     */
    public Date getClosedDate()
    {
        return closedDate;
    }


    /**
     * Set the value of ClosedDate
     *
     * @param v new value
     */
    public void setClosedDate(Date v) 
    {

        if (!ObjectUtils.equals(this.closedDate, v))
        {
            this.closedDate = v;
            setModified(true);
        }


    }

    /**
     * Get the CostFrom
     *
     * @return int
     */
    public int getCostFrom()
    {
        return costFrom;
    }


    /**
     * Set the value of CostFrom
     *
     * @param v new value
     */
    public void setCostFrom(int v) 
    {

        if (this.costFrom != v)
        {
            this.costFrom = v;
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
     * Get the State
     *
     * @return int
     */
    public int getState()
    {
        return state;
    }


    /**
     * Set the value of State
     *
     * @param v new value
     */
    public void setState(int v) 
    {

        if (this.state != v)
        {
            this.state = v;
            setModified(true);
        }


    }

    /**
     * Get the StateUptime
     *
     * @return Date
     */
    public Date getStateUptime()
    {
        return stateUptime;
    }


    /**
     * Set the value of StateUptime
     *
     * @param v new value
     */
    public void setStateUptime(Date v) 
    {

        if (!ObjectUtils.equals(this.stateUptime, v))
        {
            this.stateUptime = v;
            setModified(true);
        }


    }

    /**
     * Get the StateIntro
     *
     * @return String
     */
    public String getStateIntro()
    {
        return stateIntro;
    }


    /**
     * Set the value of StateIntro
     *
     * @param v new value
     */
    public void setStateIntro(String v) 
    {

        if (!ObjectUtils.equals(this.stateIntro, v))
        {
            this.stateIntro = v;
            setModified(true);
        }


    }

    /**
     * Get the StuFrom
     *
     * @return int
     */
    public int getStuFrom()
    {
        return stuFrom;
    }


    /**
     * Set the value of StuFrom
     *
     * @param v new value
     */
    public void setStuFrom(int v) 
    {

        if (this.stuFrom != v)
        {
            this.stuFrom = v;
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
            fieldNames.add("Code");
            fieldNames.add("Ename");
            fieldNames.add("Cname");
            fieldNames.add("HeadPic");
            fieldNames.add("Sex");
            fieldNames.add("PassNumb");
            fieldNames.add("Birthday");
            fieldNames.add("Nation");
            fieldNames.add("Address");
            fieldNames.add("ClosedDate");
            fieldNames.add("CostFrom");
            fieldNames.add("Phone");
            fieldNames.add("Email");
            fieldNames.add("State");
            fieldNames.add("StateUptime");
            fieldNames.add("StateIntro");
            fieldNames.add("StuFrom");
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
        if (name.equals("Code"))
        {
            return new Integer(getCode());
        }
        if (name.equals("Ename"))
        {
            return getEname();
        }
        if (name.equals("Cname"))
        {
            return getCname();
        }
        if (name.equals("HeadPic"))
        {
            return getHeadPic();
        }
        if (name.equals("Sex"))
        {
            return new Integer(getSex());
        }
        if (name.equals("PassNumb"))
        {
            return getPassNumb();
        }
        if (name.equals("Birthday"))
        {
            return getBirthday();
        }
        if (name.equals("Nation"))
        {
            return new Integer(getNation());
        }
        if (name.equals("Address"))
        {
            return getAddress();
        }
        if (name.equals("ClosedDate"))
        {
            return getClosedDate();
        }
        if (name.equals("CostFrom"))
        {
            return new Integer(getCostFrom());
        }
        if (name.equals("Phone"))
        {
            return getPhone();
        }
        if (name.equals("Email"))
        {
            return getEmail();
        }
        if (name.equals("State"))
        {
            return new Integer(getState());
        }
        if (name.equals("StateUptime"))
        {
            return getStateUptime();
        }
        if (name.equals("StateIntro"))
        {
            return getStateIntro();
        }
        if (name.equals("StuFrom"))
        {
            return new Integer(getStuFrom());
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
        if (name.equals("Code"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCode(((Integer) value).intValue());
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
        if (name.equals("HeadPic"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setHeadPic((String) value);
            return true;
        }
        if (name.equals("Sex"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setSex(((Integer) value).intValue());
            return true;
        }
        if (name.equals("PassNumb"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setPassNumb((String) value);
            return true;
        }
        if (name.equals("Birthday"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setBirthday((String) value);
            return true;
        }
        if (name.equals("Nation"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setNation(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Address"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setAddress((String) value);
            return true;
        }
        if (name.equals("ClosedDate"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setClosedDate((Date) value);
            return true;
        }
        if (name.equals("CostFrom"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCostFrom(((Integer) value).intValue());
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
        if (name.equals("State"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setState(((Integer) value).intValue());
            return true;
        }
        if (name.equals("StateUptime"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setStateUptime((Date) value);
            return true;
        }
        if (name.equals("StateIntro"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setStateIntro((String) value);
            return true;
        }
        if (name.equals("StuFrom"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setStuFrom(((Integer) value).intValue());
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
        if (name.equals(StudentPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(StudentPeer.CODE))
        {
            return new Integer(getCode());
        }
        if (name.equals(StudentPeer.ENAME))
        {
            return getEname();
        }
        if (name.equals(StudentPeer.CNAME))
        {
            return getCname();
        }
        if (name.equals(StudentPeer.HEAD_PIC))
        {
            return getHeadPic();
        }
        if (name.equals(StudentPeer.SEX))
        {
            return new Integer(getSex());
        }
        if (name.equals(StudentPeer.PASS_NUMB))
        {
            return getPassNumb();
        }
        if (name.equals(StudentPeer.BIRTHDAY))
        {
            return getBirthday();
        }
        if (name.equals(StudentPeer.NATION))
        {
            return new Integer(getNation());
        }
        if (name.equals(StudentPeer.ADDRESS))
        {
            return getAddress();
        }
        if (name.equals(StudentPeer.CLOSED_DATE))
        {
            return getClosedDate();
        }
        if (name.equals(StudentPeer.COST_FROM))
        {
            return new Integer(getCostFrom());
        }
        if (name.equals(StudentPeer.PHONE))
        {
            return getPhone();
        }
        if (name.equals(StudentPeer.EMAIL))
        {
            return getEmail();
        }
        if (name.equals(StudentPeer.STATE))
        {
            return new Integer(getState());
        }
        if (name.equals(StudentPeer.STATE_UPTIME))
        {
            return getStateUptime();
        }
        if (name.equals(StudentPeer.STATE_INTRO))
        {
            return getStateIntro();
        }
        if (name.equals(StudentPeer.STU_FROM))
        {
            return new Integer(getStuFrom());
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
      if (StudentPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (StudentPeer.CODE.equals(name))
        {
            return setByName("Code", value);
        }
      if (StudentPeer.ENAME.equals(name))
        {
            return setByName("Ename", value);
        }
      if (StudentPeer.CNAME.equals(name))
        {
            return setByName("Cname", value);
        }
      if (StudentPeer.HEAD_PIC.equals(name))
        {
            return setByName("HeadPic", value);
        }
      if (StudentPeer.SEX.equals(name))
        {
            return setByName("Sex", value);
        }
      if (StudentPeer.PASS_NUMB.equals(name))
        {
            return setByName("PassNumb", value);
        }
      if (StudentPeer.BIRTHDAY.equals(name))
        {
            return setByName("Birthday", value);
        }
      if (StudentPeer.NATION.equals(name))
        {
            return setByName("Nation", value);
        }
      if (StudentPeer.ADDRESS.equals(name))
        {
            return setByName("Address", value);
        }
      if (StudentPeer.CLOSED_DATE.equals(name))
        {
            return setByName("ClosedDate", value);
        }
      if (StudentPeer.COST_FROM.equals(name))
        {
            return setByName("CostFrom", value);
        }
      if (StudentPeer.PHONE.equals(name))
        {
            return setByName("Phone", value);
        }
      if (StudentPeer.EMAIL.equals(name))
        {
            return setByName("Email", value);
        }
      if (StudentPeer.STATE.equals(name))
        {
            return setByName("State", value);
        }
      if (StudentPeer.STATE_UPTIME.equals(name))
        {
            return setByName("StateUptime", value);
        }
      if (StudentPeer.STATE_INTRO.equals(name))
        {
            return setByName("StateIntro", value);
        }
      if (StudentPeer.STU_FROM.equals(name))
        {
            return setByName("StuFrom", value);
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
            return new Integer(getCode());
        }
        if (pos == 2)
        {
            return getEname();
        }
        if (pos == 3)
        {
            return getCname();
        }
        if (pos == 4)
        {
            return getHeadPic();
        }
        if (pos == 5)
        {
            return new Integer(getSex());
        }
        if (pos == 6)
        {
            return getPassNumb();
        }
        if (pos == 7)
        {
            return getBirthday();
        }
        if (pos == 8)
        {
            return new Integer(getNation());
        }
        if (pos == 9)
        {
            return getAddress();
        }
        if (pos == 10)
        {
            return getClosedDate();
        }
        if (pos == 11)
        {
            return new Integer(getCostFrom());
        }
        if (pos == 12)
        {
            return getPhone();
        }
        if (pos == 13)
        {
            return getEmail();
        }
        if (pos == 14)
        {
            return new Integer(getState());
        }
        if (pos == 15)
        {
            return getStateUptime();
        }
        if (pos == 16)
        {
            return getStateIntro();
        }
        if (pos == 17)
        {
            return new Integer(getStuFrom());
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
            return setByName("Code", value);
        }
    if (position == 2)
        {
            return setByName("Ename", value);
        }
    if (position == 3)
        {
            return setByName("Cname", value);
        }
    if (position == 4)
        {
            return setByName("HeadPic", value);
        }
    if (position == 5)
        {
            return setByName("Sex", value);
        }
    if (position == 6)
        {
            return setByName("PassNumb", value);
        }
    if (position == 7)
        {
            return setByName("Birthday", value);
        }
    if (position == 8)
        {
            return setByName("Nation", value);
        }
    if (position == 9)
        {
            return setByName("Address", value);
        }
    if (position == 10)
        {
            return setByName("ClosedDate", value);
        }
    if (position == 11)
        {
            return setByName("CostFrom", value);
        }
    if (position == 12)
        {
            return setByName("Phone", value);
        }
    if (position == 13)
        {
            return setByName("Email", value);
        }
    if (position == 14)
        {
            return setByName("State", value);
        }
    if (position == 15)
        {
            return setByName("StateUptime", value);
        }
    if (position == 16)
        {
            return setByName("StateIntro", value);
        }
    if (position == 17)
        {
            return setByName("StuFrom", value);
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
        save(StudentPeer.DATABASE_NAME);
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
                    StudentPeer.doInsert((Student) this, con);
                    setNew(false);
                }
                else
                {
                    StudentPeer.doUpdate((Student) this, con);
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
    public Student copy() throws TorqueException
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
    public Student copy(Connection con) throws TorqueException
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
    public Student copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new Student(), deepcopy);
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
    public Student copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new Student(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected Student copyInto(Student copyObj) throws TorqueException
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
    protected Student copyInto(Student copyObj, Connection con) throws TorqueException
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
    protected Student copyInto(Student copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setCode(code);
        copyObj.setEname(ename);
        copyObj.setCname(cname);
        copyObj.setHeadPic(headPic);
        copyObj.setSex(sex);
        copyObj.setPassNumb(passNumb);
        copyObj.setBirthday(birthday);
        copyObj.setNation(nation);
        copyObj.setAddress(address);
        copyObj.setClosedDate(closedDate);
        copyObj.setCostFrom(costFrom);
        copyObj.setPhone(phone);
        copyObj.setEmail(email);
        copyObj.setState(state);
        copyObj.setStateUptime(stateUptime);
        copyObj.setStateIntro(stateIntro);
        copyObj.setStuFrom(stuFrom);

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
    protected Student copyInto(Student copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setCode(code);
        copyObj.setEname(ename);
        copyObj.setCname(cname);
        copyObj.setHeadPic(headPic);
        copyObj.setSex(sex);
        copyObj.setPassNumb(passNumb);
        copyObj.setBirthday(birthday);
        copyObj.setNation(nation);
        copyObj.setAddress(address);
        copyObj.setClosedDate(closedDate);
        copyObj.setCostFrom(costFrom);
        copyObj.setPhone(phone);
        copyObj.setEmail(email);
        copyObj.setState(state);
        copyObj.setStateUptime(stateUptime);
        copyObj.setStateIntro(stateIntro);
        copyObj.setStuFrom(stuFrom);

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
    public StudentPeer getPeer()
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
        return StudentPeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("Student:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("Code = ")
           .append(getCode())
           .append("\n");
        str.append("Ename = ")
           .append(getEname())
           .append("\n");
        str.append("Cname = ")
           .append(getCname())
           .append("\n");
        str.append("HeadPic = ")
           .append(getHeadPic())
           .append("\n");
        str.append("Sex = ")
           .append(getSex())
           .append("\n");
        str.append("PassNumb = ")
           .append(getPassNumb())
           .append("\n");
        str.append("Birthday = ")
           .append(getBirthday())
           .append("\n");
        str.append("Nation = ")
           .append(getNation())
           .append("\n");
        str.append("Address = ")
           .append(getAddress())
           .append("\n");
        str.append("ClosedDate = ")
           .append(getClosedDate())
           .append("\n");
        str.append("CostFrom = ")
           .append(getCostFrom())
           .append("\n");
        str.append("Phone = ")
           .append(getPhone())
           .append("\n");
        str.append("Email = ")
           .append(getEmail())
           .append("\n");
        str.append("State = ")
           .append(getState())
           .append("\n");
        str.append("StateUptime = ")
           .append(getStateUptime())
           .append("\n");
        str.append("StateIntro = ")
           .append(getStateIntro())
           .append("\n");
        str.append("StuFrom = ")
           .append(getStuFrom())
           .append("\n");
        return(str.toString());
    }
}
