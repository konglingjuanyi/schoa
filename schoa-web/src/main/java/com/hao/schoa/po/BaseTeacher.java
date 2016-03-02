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
 * extended all references should be to Teacher
 */
public abstract class BaseTeacher extends BaseObject
{
    /** The Peer class */
    private static final TeacherPeer peer =
        new TeacherPeer();


    /** The value for the id field */
    private int id;

    /** The value for the name field */
    private String name;

    /** The value for the code field */
    private int code = 0;

    /** The value for the sex field */
    private int sex = 0;

    /** The value for the birthday field */
    private String birthday;

    /** The value for the married field */
    private int married = 0;

    /** The value for the hometown field */
    private String hometown;

    /** The value for the graduated field */
    private String graduated;

    /** The value for the pro field */
    private String pro;

    /** The value for the address field */
    private String address;

    /** The value for the experience field */
    private String experience;

    /** The value for the research field */
    private String research;

    /** The value for the readingSchool field */
    private String readingSchool;

    /** The value for the phone field */
    private String phone;

    /** The value for the email field */
    private String email;

    /** The value for the entryTime field */
    private Date entryTime;

    /** The value for the lizhiTime field */
    private Date lizhiTime;

    /** The value for the type field */
    private int type = 0;

    /** The value for the cardNumb field */
    private String cardNumb;

    /** The value for the headPic field */
    private String headPic;

    /** The value for the state field */
    private int state = 0;

    /** The value for the stateUptime field */
    private Date stateUptime;


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
     * Get the Married
     *
     * @return int
     */
    public int getMarried()
    {
        return married;
    }


    /**
     * Set the value of Married
     *
     * @param v new value
     */
    public void setMarried(int v) 
    {

        if (this.married != v)
        {
            this.married = v;
            setModified(true);
        }


    }

    /**
     * Get the Hometown
     *
     * @return String
     */
    public String getHometown()
    {
        return hometown;
    }


    /**
     * Set the value of Hometown
     *
     * @param v new value
     */
    public void setHometown(String v) 
    {

        if (!ObjectUtils.equals(this.hometown, v))
        {
            this.hometown = v;
            setModified(true);
        }


    }

    /**
     * Get the Graduated
     *
     * @return String
     */
    public String getGraduated()
    {
        return graduated;
    }


    /**
     * Set the value of Graduated
     *
     * @param v new value
     */
    public void setGraduated(String v) 
    {

        if (!ObjectUtils.equals(this.graduated, v))
        {
            this.graduated = v;
            setModified(true);
        }


    }

    /**
     * Get the Pro
     *
     * @return String
     */
    public String getPro()
    {
        return pro;
    }


    /**
     * Set the value of Pro
     *
     * @param v new value
     */
    public void setPro(String v) 
    {

        if (!ObjectUtils.equals(this.pro, v))
        {
            this.pro = v;
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
     * Get the Experience
     *
     * @return String
     */
    public String getExperience()
    {
        return experience;
    }


    /**
     * Set the value of Experience
     *
     * @param v new value
     */
    public void setExperience(String v) 
    {

        if (!ObjectUtils.equals(this.experience, v))
        {
            this.experience = v;
            setModified(true);
        }


    }

    /**
     * Get the Research
     *
     * @return String
     */
    public String getResearch()
    {
        return research;
    }


    /**
     * Set the value of Research
     *
     * @param v new value
     */
    public void setResearch(String v) 
    {

        if (!ObjectUtils.equals(this.research, v))
        {
            this.research = v;
            setModified(true);
        }


    }

    /**
     * Get the ReadingSchool
     *
     * @return String
     */
    public String getReadingSchool()
    {
        return readingSchool;
    }


    /**
     * Set the value of ReadingSchool
     *
     * @param v new value
     */
    public void setReadingSchool(String v) 
    {

        if (!ObjectUtils.equals(this.readingSchool, v))
        {
            this.readingSchool = v;
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
     * Get the EntryTime
     *
     * @return Date
     */
    public Date getEntryTime()
    {
        return entryTime;
    }


    /**
     * Set the value of EntryTime
     *
     * @param v new value
     */
    public void setEntryTime(Date v) 
    {

        if (!ObjectUtils.equals(this.entryTime, v))
        {
            this.entryTime = v;
            setModified(true);
        }


    }

    /**
     * Get the LizhiTime
     *
     * @return Date
     */
    public Date getLizhiTime()
    {
        return lizhiTime;
    }


    /**
     * Set the value of LizhiTime
     *
     * @param v new value
     */
    public void setLizhiTime(Date v) 
    {

        if (!ObjectUtils.equals(this.lizhiTime, v))
        {
            this.lizhiTime = v;
            setModified(true);
        }


    }

    /**
     * Get the Type
     *
     * @return int
     */
    public int getType()
    {
        return type;
    }


    /**
     * Set the value of Type
     *
     * @param v new value
     */
    public void setType(int v) 
    {

        if (this.type != v)
        {
            this.type = v;
            setModified(true);
        }


    }

    /**
     * Get the CardNumb
     *
     * @return String
     */
    public String getCardNumb()
    {
        return cardNumb;
    }


    /**
     * Set the value of CardNumb
     *
     * @param v new value
     */
    public void setCardNumb(String v) 
    {

        if (!ObjectUtils.equals(this.cardNumb, v))
        {
            this.cardNumb = v;
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
            fieldNames.add("Code");
            fieldNames.add("Sex");
            fieldNames.add("Birthday");
            fieldNames.add("Married");
            fieldNames.add("Hometown");
            fieldNames.add("Graduated");
            fieldNames.add("Pro");
            fieldNames.add("Address");
            fieldNames.add("Experience");
            fieldNames.add("Research");
            fieldNames.add("ReadingSchool");
            fieldNames.add("Phone");
            fieldNames.add("Email");
            fieldNames.add("EntryTime");
            fieldNames.add("LizhiTime");
            fieldNames.add("Type");
            fieldNames.add("CardNumb");
            fieldNames.add("HeadPic");
            fieldNames.add("State");
            fieldNames.add("StateUptime");
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
        if (name.equals("Code"))
        {
            return new Integer(getCode());
        }
        if (name.equals("Sex"))
        {
            return new Integer(getSex());
        }
        if (name.equals("Birthday"))
        {
            return getBirthday();
        }
        if (name.equals("Married"))
        {
            return new Integer(getMarried());
        }
        if (name.equals("Hometown"))
        {
            return getHometown();
        }
        if (name.equals("Graduated"))
        {
            return getGraduated();
        }
        if (name.equals("Pro"))
        {
            return getPro();
        }
        if (name.equals("Address"))
        {
            return getAddress();
        }
        if (name.equals("Experience"))
        {
            return getExperience();
        }
        if (name.equals("Research"))
        {
            return getResearch();
        }
        if (name.equals("ReadingSchool"))
        {
            return getReadingSchool();
        }
        if (name.equals("Phone"))
        {
            return getPhone();
        }
        if (name.equals("Email"))
        {
            return getEmail();
        }
        if (name.equals("EntryTime"))
        {
            return getEntryTime();
        }
        if (name.equals("LizhiTime"))
        {
            return getLizhiTime();
        }
        if (name.equals("Type"))
        {
            return new Integer(getType());
        }
        if (name.equals("CardNumb"))
        {
            return getCardNumb();
        }
        if (name.equals("HeadPic"))
        {
            return getHeadPic();
        }
        if (name.equals("State"))
        {
            return new Integer(getState());
        }
        if (name.equals("StateUptime"))
        {
            return getStateUptime();
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
        if (name.equals("Code"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCode(((Integer) value).intValue());
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
        if (name.equals("Married"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setMarried(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Hometown"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setHometown((String) value);
            return true;
        }
        if (name.equals("Graduated"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setGraduated((String) value);
            return true;
        }
        if (name.equals("Pro"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setPro((String) value);
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
        if (name.equals("Experience"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setExperience((String) value);
            return true;
        }
        if (name.equals("Research"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setResearch((String) value);
            return true;
        }
        if (name.equals("ReadingSchool"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setReadingSchool((String) value);
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
        if (name.equals("EntryTime"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setEntryTime((Date) value);
            return true;
        }
        if (name.equals("LizhiTime"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setLizhiTime((Date) value);
            return true;
        }
        if (name.equals("Type"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setType(((Integer) value).intValue());
            return true;
        }
        if (name.equals("CardNumb"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setCardNumb((String) value);
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
        if (name.equals(TeacherPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(TeacherPeer.NAME))
        {
            return getName();
        }
        if (name.equals(TeacherPeer.CODE))
        {
            return new Integer(getCode());
        }
        if (name.equals(TeacherPeer.SEX))
        {
            return new Integer(getSex());
        }
        if (name.equals(TeacherPeer.BIRTHDAY))
        {
            return getBirthday();
        }
        if (name.equals(TeacherPeer.MARRIED))
        {
            return new Integer(getMarried());
        }
        if (name.equals(TeacherPeer.HOMETOWN))
        {
            return getHometown();
        }
        if (name.equals(TeacherPeer.GRADUATED))
        {
            return getGraduated();
        }
        if (name.equals(TeacherPeer.PRO))
        {
            return getPro();
        }
        if (name.equals(TeacherPeer.ADDRESS))
        {
            return getAddress();
        }
        if (name.equals(TeacherPeer.EXPERIENCE))
        {
            return getExperience();
        }
        if (name.equals(TeacherPeer.RESEARCH))
        {
            return getResearch();
        }
        if (name.equals(TeacherPeer.READING_SCHOOL))
        {
            return getReadingSchool();
        }
        if (name.equals(TeacherPeer.PHONE))
        {
            return getPhone();
        }
        if (name.equals(TeacherPeer.EMAIL))
        {
            return getEmail();
        }
        if (name.equals(TeacherPeer.ENTRY_TIME))
        {
            return getEntryTime();
        }
        if (name.equals(TeacherPeer.LIZHI_TIME))
        {
            return getLizhiTime();
        }
        if (name.equals(TeacherPeer.TYPE))
        {
            return new Integer(getType());
        }
        if (name.equals(TeacherPeer.CARD_NUMB))
        {
            return getCardNumb();
        }
        if (name.equals(TeacherPeer.HEAD_PIC))
        {
            return getHeadPic();
        }
        if (name.equals(TeacherPeer.STATE))
        {
            return new Integer(getState());
        }
        if (name.equals(TeacherPeer.STATE_UPTIME))
        {
            return getStateUptime();
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
      if (TeacherPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (TeacherPeer.NAME.equals(name))
        {
            return setByName("Name", value);
        }
      if (TeacherPeer.CODE.equals(name))
        {
            return setByName("Code", value);
        }
      if (TeacherPeer.SEX.equals(name))
        {
            return setByName("Sex", value);
        }
      if (TeacherPeer.BIRTHDAY.equals(name))
        {
            return setByName("Birthday", value);
        }
      if (TeacherPeer.MARRIED.equals(name))
        {
            return setByName("Married", value);
        }
      if (TeacherPeer.HOMETOWN.equals(name))
        {
            return setByName("Hometown", value);
        }
      if (TeacherPeer.GRADUATED.equals(name))
        {
            return setByName("Graduated", value);
        }
      if (TeacherPeer.PRO.equals(name))
        {
            return setByName("Pro", value);
        }
      if (TeacherPeer.ADDRESS.equals(name))
        {
            return setByName("Address", value);
        }
      if (TeacherPeer.EXPERIENCE.equals(name))
        {
            return setByName("Experience", value);
        }
      if (TeacherPeer.RESEARCH.equals(name))
        {
            return setByName("Research", value);
        }
      if (TeacherPeer.READING_SCHOOL.equals(name))
        {
            return setByName("ReadingSchool", value);
        }
      if (TeacherPeer.PHONE.equals(name))
        {
            return setByName("Phone", value);
        }
      if (TeacherPeer.EMAIL.equals(name))
        {
            return setByName("Email", value);
        }
      if (TeacherPeer.ENTRY_TIME.equals(name))
        {
            return setByName("EntryTime", value);
        }
      if (TeacherPeer.LIZHI_TIME.equals(name))
        {
            return setByName("LizhiTime", value);
        }
      if (TeacherPeer.TYPE.equals(name))
        {
            return setByName("Type", value);
        }
      if (TeacherPeer.CARD_NUMB.equals(name))
        {
            return setByName("CardNumb", value);
        }
      if (TeacherPeer.HEAD_PIC.equals(name))
        {
            return setByName("HeadPic", value);
        }
      if (TeacherPeer.STATE.equals(name))
        {
            return setByName("State", value);
        }
      if (TeacherPeer.STATE_UPTIME.equals(name))
        {
            return setByName("StateUptime", value);
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
            return new Integer(getCode());
        }
        if (pos == 3)
        {
            return new Integer(getSex());
        }
        if (pos == 4)
        {
            return getBirthday();
        }
        if (pos == 5)
        {
            return new Integer(getMarried());
        }
        if (pos == 6)
        {
            return getHometown();
        }
        if (pos == 7)
        {
            return getGraduated();
        }
        if (pos == 8)
        {
            return getPro();
        }
        if (pos == 9)
        {
            return getAddress();
        }
        if (pos == 10)
        {
            return getExperience();
        }
        if (pos == 11)
        {
            return getResearch();
        }
        if (pos == 12)
        {
            return getReadingSchool();
        }
        if (pos == 13)
        {
            return getPhone();
        }
        if (pos == 14)
        {
            return getEmail();
        }
        if (pos == 15)
        {
            return getEntryTime();
        }
        if (pos == 16)
        {
            return getLizhiTime();
        }
        if (pos == 17)
        {
            return new Integer(getType());
        }
        if (pos == 18)
        {
            return getCardNumb();
        }
        if (pos == 19)
        {
            return getHeadPic();
        }
        if (pos == 20)
        {
            return new Integer(getState());
        }
        if (pos == 21)
        {
            return getStateUptime();
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
            return setByName("Code", value);
        }
    if (position == 3)
        {
            return setByName("Sex", value);
        }
    if (position == 4)
        {
            return setByName("Birthday", value);
        }
    if (position == 5)
        {
            return setByName("Married", value);
        }
    if (position == 6)
        {
            return setByName("Hometown", value);
        }
    if (position == 7)
        {
            return setByName("Graduated", value);
        }
    if (position == 8)
        {
            return setByName("Pro", value);
        }
    if (position == 9)
        {
            return setByName("Address", value);
        }
    if (position == 10)
        {
            return setByName("Experience", value);
        }
    if (position == 11)
        {
            return setByName("Research", value);
        }
    if (position == 12)
        {
            return setByName("ReadingSchool", value);
        }
    if (position == 13)
        {
            return setByName("Phone", value);
        }
    if (position == 14)
        {
            return setByName("Email", value);
        }
    if (position == 15)
        {
            return setByName("EntryTime", value);
        }
    if (position == 16)
        {
            return setByName("LizhiTime", value);
        }
    if (position == 17)
        {
            return setByName("Type", value);
        }
    if (position == 18)
        {
            return setByName("CardNumb", value);
        }
    if (position == 19)
        {
            return setByName("HeadPic", value);
        }
    if (position == 20)
        {
            return setByName("State", value);
        }
    if (position == 21)
        {
            return setByName("StateUptime", value);
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
        save(TeacherPeer.DATABASE_NAME);
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
                    TeacherPeer.doInsert((Teacher) this, con);
                    setNew(false);
                }
                else
                {
                    TeacherPeer.doUpdate((Teacher) this, con);
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
    public Teacher copy() throws TorqueException
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
    public Teacher copy(Connection con) throws TorqueException
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
    public Teacher copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new Teacher(), deepcopy);
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
    public Teacher copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new Teacher(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected Teacher copyInto(Teacher copyObj) throws TorqueException
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
    protected Teacher copyInto(Teacher copyObj, Connection con) throws TorqueException
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
    protected Teacher copyInto(Teacher copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setName(name);
        copyObj.setCode(code);
        copyObj.setSex(sex);
        copyObj.setBirthday(birthday);
        copyObj.setMarried(married);
        copyObj.setHometown(hometown);
        copyObj.setGraduated(graduated);
        copyObj.setPro(pro);
        copyObj.setAddress(address);
        copyObj.setExperience(experience);
        copyObj.setResearch(research);
        copyObj.setReadingSchool(readingSchool);
        copyObj.setPhone(phone);
        copyObj.setEmail(email);
        copyObj.setEntryTime(entryTime);
        copyObj.setLizhiTime(lizhiTime);
        copyObj.setType(type);
        copyObj.setCardNumb(cardNumb);
        copyObj.setHeadPic(headPic);
        copyObj.setState(state);
        copyObj.setStateUptime(stateUptime);

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
    protected Teacher copyInto(Teacher copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setName(name);
        copyObj.setCode(code);
        copyObj.setSex(sex);
        copyObj.setBirthday(birthday);
        copyObj.setMarried(married);
        copyObj.setHometown(hometown);
        copyObj.setGraduated(graduated);
        copyObj.setPro(pro);
        copyObj.setAddress(address);
        copyObj.setExperience(experience);
        copyObj.setResearch(research);
        copyObj.setReadingSchool(readingSchool);
        copyObj.setPhone(phone);
        copyObj.setEmail(email);
        copyObj.setEntryTime(entryTime);
        copyObj.setLizhiTime(lizhiTime);
        copyObj.setType(type);
        copyObj.setCardNumb(cardNumb);
        copyObj.setHeadPic(headPic);
        copyObj.setState(state);
        copyObj.setStateUptime(stateUptime);

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
    public TeacherPeer getPeer()
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
        return TeacherPeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("Teacher:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("Name = ")
           .append(getName())
           .append("\n");
        str.append("Code = ")
           .append(getCode())
           .append("\n");
        str.append("Sex = ")
           .append(getSex())
           .append("\n");
        str.append("Birthday = ")
           .append(getBirthday())
           .append("\n");
        str.append("Married = ")
           .append(getMarried())
           .append("\n");
        str.append("Hometown = ")
           .append(getHometown())
           .append("\n");
        str.append("Graduated = ")
           .append(getGraduated())
           .append("\n");
        str.append("Pro = ")
           .append(getPro())
           .append("\n");
        str.append("Address = ")
           .append(getAddress())
           .append("\n");
        str.append("Experience = ")
           .append(getExperience())
           .append("\n");
        str.append("Research = ")
           .append(getResearch())
           .append("\n");
        str.append("ReadingSchool = ")
           .append(getReadingSchool())
           .append("\n");
        str.append("Phone = ")
           .append(getPhone())
           .append("\n");
        str.append("Email = ")
           .append(getEmail())
           .append("\n");
        str.append("EntryTime = ")
           .append(getEntryTime())
           .append("\n");
        str.append("LizhiTime = ")
           .append(getLizhiTime())
           .append("\n");
        str.append("Type = ")
           .append(getType())
           .append("\n");
        str.append("CardNumb = ")
           .append(getCardNumb())
           .append("\n");
        str.append("HeadPic = ")
           .append(getHeadPic())
           .append("\n");
        str.append("State = ")
           .append(getState())
           .append("\n");
        str.append("StateUptime = ")
           .append(getStateUptime())
           .append("\n");
        return(str.toString());
    }
}
