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
 * extended all references should be to QuestionPaper
 */
public abstract class BaseQuestionPaper extends BaseObject
{
    /** The Peer class */
    private static final QuestionPaperPeer peer =
        new QuestionPaperPeer();


    /** The value for the id field */
    private int id;

    /** The value for the title field */
    private String title;

    /** The value for the member field */
    private String member;

    /** The value for the questions field */
    private String questions;

    /** The value for the createTime field */
    private Date createTime;

    /** The value for the createMemberId field */
    private int createMemberId = 0;

    /** The value for the createMember field */
    private String createMember;

    /** The value for the valid field */
    private int valid = 1;

    /** The value for the delTime field */
    private Date delTime;

    /** The value for the delMemberId field */
    private int delMemberId = 0;

    /** The value for the delMember field */
    private String delMember;


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
     * Get the Title
     *
     * @return String
     */
    public String getTitle()
    {
        return title;
    }


    /**
     * Set the value of Title
     *
     * @param v new value
     */
    public void setTitle(String v) 
    {

        if (!ObjectUtils.equals(this.title, v))
        {
            this.title = v;
            setModified(true);
        }


    }

    /**
     * Get the Member
     *
     * @return String
     */
    public String getMember()
    {
        return member;
    }


    /**
     * Set the value of Member
     *
     * @param v new value
     */
    public void setMember(String v) 
    {

        if (!ObjectUtils.equals(this.member, v))
        {
            this.member = v;
            setModified(true);
        }


    }

    /**
     * Get the Questions
     *
     * @return String
     */
    public String getQuestions()
    {
        return questions;
    }


    /**
     * Set the value of Questions
     *
     * @param v new value
     */
    public void setQuestions(String v) 
    {

        if (!ObjectUtils.equals(this.questions, v))
        {
            this.questions = v;
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
     * Get the DelTime
     *
     * @return Date
     */
    public Date getDelTime()
    {
        return delTime;
    }


    /**
     * Set the value of DelTime
     *
     * @param v new value
     */
    public void setDelTime(Date v) 
    {

        if (!ObjectUtils.equals(this.delTime, v))
        {
            this.delTime = v;
            setModified(true);
        }


    }

    /**
     * Get the DelMemberId
     *
     * @return int
     */
    public int getDelMemberId()
    {
        return delMemberId;
    }


    /**
     * Set the value of DelMemberId
     *
     * @param v new value
     */
    public void setDelMemberId(int v) 
    {

        if (this.delMemberId != v)
        {
            this.delMemberId = v;
            setModified(true);
        }


    }

    /**
     * Get the DelMember
     *
     * @return String
     */
    public String getDelMember()
    {
        return delMember;
    }


    /**
     * Set the value of DelMember
     *
     * @param v new value
     */
    public void setDelMember(String v) 
    {

        if (!ObjectUtils.equals(this.delMember, v))
        {
            this.delMember = v;
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
            fieldNames.add("Title");
            fieldNames.add("Member");
            fieldNames.add("Questions");
            fieldNames.add("CreateTime");
            fieldNames.add("CreateMemberId");
            fieldNames.add("CreateMember");
            fieldNames.add("Valid");
            fieldNames.add("DelTime");
            fieldNames.add("DelMemberId");
            fieldNames.add("DelMember");
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
        if (name.equals("Title"))
        {
            return getTitle();
        }
        if (name.equals("Member"))
        {
            return getMember();
        }
        if (name.equals("Questions"))
        {
            return getQuestions();
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
        if (name.equals("Valid"))
        {
            return new Integer(getValid());
        }
        if (name.equals("DelTime"))
        {
            return getDelTime();
        }
        if (name.equals("DelMemberId"))
        {
            return new Integer(getDelMemberId());
        }
        if (name.equals("DelMember"))
        {
            return getDelMember();
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
        if (name.equals("Title"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setTitle((String) value);
            return true;
        }
        if (name.equals("Member"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setMember((String) value);
            return true;
        }
        if (name.equals("Questions"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setQuestions((String) value);
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
        if (name.equals("Valid"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setValid(((Integer) value).intValue());
            return true;
        }
        if (name.equals("DelTime"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setDelTime((Date) value);
            return true;
        }
        if (name.equals("DelMemberId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setDelMemberId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("DelMember"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setDelMember((String) value);
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
        if (name.equals(QuestionPaperPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(QuestionPaperPeer.TITLE))
        {
            return getTitle();
        }
        if (name.equals(QuestionPaperPeer.MEMBER))
        {
            return getMember();
        }
        if (name.equals(QuestionPaperPeer.QUESTIONS))
        {
            return getQuestions();
        }
        if (name.equals(QuestionPaperPeer.CREATE_TIME))
        {
            return getCreateTime();
        }
        if (name.equals(QuestionPaperPeer.CREATE_MEMBER_ID))
        {
            return new Integer(getCreateMemberId());
        }
        if (name.equals(QuestionPaperPeer.CREATE_MEMBER))
        {
            return getCreateMember();
        }
        if (name.equals(QuestionPaperPeer.VALID))
        {
            return new Integer(getValid());
        }
        if (name.equals(QuestionPaperPeer.DEL_TIME))
        {
            return getDelTime();
        }
        if (name.equals(QuestionPaperPeer.DEL_MEMBER_ID))
        {
            return new Integer(getDelMemberId());
        }
        if (name.equals(QuestionPaperPeer.DEL_MEMBER))
        {
            return getDelMember();
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
      if (QuestionPaperPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (QuestionPaperPeer.TITLE.equals(name))
        {
            return setByName("Title", value);
        }
      if (QuestionPaperPeer.MEMBER.equals(name))
        {
            return setByName("Member", value);
        }
      if (QuestionPaperPeer.QUESTIONS.equals(name))
        {
            return setByName("Questions", value);
        }
      if (QuestionPaperPeer.CREATE_TIME.equals(name))
        {
            return setByName("CreateTime", value);
        }
      if (QuestionPaperPeer.CREATE_MEMBER_ID.equals(name))
        {
            return setByName("CreateMemberId", value);
        }
      if (QuestionPaperPeer.CREATE_MEMBER.equals(name))
        {
            return setByName("CreateMember", value);
        }
      if (QuestionPaperPeer.VALID.equals(name))
        {
            return setByName("Valid", value);
        }
      if (QuestionPaperPeer.DEL_TIME.equals(name))
        {
            return setByName("DelTime", value);
        }
      if (QuestionPaperPeer.DEL_MEMBER_ID.equals(name))
        {
            return setByName("DelMemberId", value);
        }
      if (QuestionPaperPeer.DEL_MEMBER.equals(name))
        {
            return setByName("DelMember", value);
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
            return getTitle();
        }
        if (pos == 2)
        {
            return getMember();
        }
        if (pos == 3)
        {
            return getQuestions();
        }
        if (pos == 4)
        {
            return getCreateTime();
        }
        if (pos == 5)
        {
            return new Integer(getCreateMemberId());
        }
        if (pos == 6)
        {
            return getCreateMember();
        }
        if (pos == 7)
        {
            return new Integer(getValid());
        }
        if (pos == 8)
        {
            return getDelTime();
        }
        if (pos == 9)
        {
            return new Integer(getDelMemberId());
        }
        if (pos == 10)
        {
            return getDelMember();
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
            return setByName("Title", value);
        }
    if (position == 2)
        {
            return setByName("Member", value);
        }
    if (position == 3)
        {
            return setByName("Questions", value);
        }
    if (position == 4)
        {
            return setByName("CreateTime", value);
        }
    if (position == 5)
        {
            return setByName("CreateMemberId", value);
        }
    if (position == 6)
        {
            return setByName("CreateMember", value);
        }
    if (position == 7)
        {
            return setByName("Valid", value);
        }
    if (position == 8)
        {
            return setByName("DelTime", value);
        }
    if (position == 9)
        {
            return setByName("DelMemberId", value);
        }
    if (position == 10)
        {
            return setByName("DelMember", value);
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
        save(QuestionPaperPeer.DATABASE_NAME);
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
                    QuestionPaperPeer.doInsert((QuestionPaper) this, con);
                    setNew(false);
                }
                else
                {
                    QuestionPaperPeer.doUpdate((QuestionPaper) this, con);
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
    public QuestionPaper copy() throws TorqueException
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
    public QuestionPaper copy(Connection con) throws TorqueException
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
    public QuestionPaper copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new QuestionPaper(), deepcopy);
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
    public QuestionPaper copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new QuestionPaper(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected QuestionPaper copyInto(QuestionPaper copyObj) throws TorqueException
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
    protected QuestionPaper copyInto(QuestionPaper copyObj, Connection con) throws TorqueException
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
    protected QuestionPaper copyInto(QuestionPaper copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setTitle(title);
        copyObj.setMember(member);
        copyObj.setQuestions(questions);
        copyObj.setCreateTime(createTime);
        copyObj.setCreateMemberId(createMemberId);
        copyObj.setCreateMember(createMember);
        copyObj.setValid(valid);
        copyObj.setDelTime(delTime);
        copyObj.setDelMemberId(delMemberId);
        copyObj.setDelMember(delMember);

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
    protected QuestionPaper copyInto(QuestionPaper copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setTitle(title);
        copyObj.setMember(member);
        copyObj.setQuestions(questions);
        copyObj.setCreateTime(createTime);
        copyObj.setCreateMemberId(createMemberId);
        copyObj.setCreateMember(createMember);
        copyObj.setValid(valid);
        copyObj.setDelTime(delTime);
        copyObj.setDelMemberId(delMemberId);
        copyObj.setDelMember(delMember);

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
    public QuestionPaperPeer getPeer()
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
        return QuestionPaperPeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("QuestionPaper:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("Title = ")
           .append(getTitle())
           .append("\n");
        str.append("Member = ")
           .append(getMember())
           .append("\n");
        str.append("Questions = ")
           .append(getQuestions())
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
        str.append("Valid = ")
           .append(getValid())
           .append("\n");
        str.append("DelTime = ")
           .append(getDelTime())
           .append("\n");
        str.append("DelMemberId = ")
           .append(getDelMemberId())
           .append("\n");
        str.append("DelMember = ")
           .append(getDelMember())
           .append("\n");
        return(str.toString());
    }
}
