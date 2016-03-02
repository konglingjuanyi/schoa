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
 * extended all references should be to Score
 */
public abstract class BaseScore extends BaseObject
{
    /** The Peer class */
    private static final ScorePeer peer =
        new ScorePeer();


    /** The value for the id field */
    private int id;

    /** The value for the classId field */
    private int classId = 0;

    /** The value for the kechengId field */
    private int kechengId = 0;

    /** The value for the studentId field */
    private int studentId = 0;

    /** The value for the scKeguan field */
    private double scKeguan = 0;

    /** The value for the scZhuguan field */
    private double scZhuguan = 0;

    /** The value for the scJuanmian field */
    private double scJuanmian = 0;

    /** The value for the scQizhong field */
    private double scQizhong = 0;

    /** The value for the scZuoye field */
    private double scZuoye = 0;

    /** The value for the scChuqin field */
    private double scChuqin = 0;

    /** The value for the scAll field */
    private double scAll = 0;

    /** The value for the sc40 field */
    private double sc40 = 0;

    /** The value for the sc20 field */
    private double sc20 = 0;

    /** The value for the remark field */
    private String remark = "0";


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
     * Get the ClassId
     *
     * @return int
     */
    public int getClassId()
    {
        return classId;
    }


    /**
     * Set the value of ClassId
     *
     * @param v new value
     */
    public void setClassId(int v) 
    {

        if (this.classId != v)
        {
            this.classId = v;
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
     * Get the ScKeguan
     *
     * @return double
     */
    public double getScKeguan()
    {
        return scKeguan;
    }


    /**
     * Set the value of ScKeguan
     *
     * @param v new value
     */
    public void setScKeguan(double v) 
    {

        if (this.scKeguan != v)
        {
            this.scKeguan = v;
            setModified(true);
        }


    }

    /**
     * Get the ScZhuguan
     *
     * @return double
     */
    public double getScZhuguan()
    {
        return scZhuguan;
    }


    /**
     * Set the value of ScZhuguan
     *
     * @param v new value
     */
    public void setScZhuguan(double v) 
    {

        if (this.scZhuguan != v)
        {
            this.scZhuguan = v;
            setModified(true);
        }


    }

    /**
     * Get the ScJuanmian
     *
     * @return double
     */
    public double getScJuanmian()
    {
        return scJuanmian;
    }


    /**
     * Set the value of ScJuanmian
     *
     * @param v new value
     */
    public void setScJuanmian(double v) 
    {

        if (this.scJuanmian != v)
        {
            this.scJuanmian = v;
            setModified(true);
        }


    }

    /**
     * Get the ScQizhong
     *
     * @return double
     */
    public double getScQizhong()
    {
        return scQizhong;
    }


    /**
     * Set the value of ScQizhong
     *
     * @param v new value
     */
    public void setScQizhong(double v) 
    {

        if (this.scQizhong != v)
        {
            this.scQizhong = v;
            setModified(true);
        }


    }

    /**
     * Get the ScZuoye
     *
     * @return double
     */
    public double getScZuoye()
    {
        return scZuoye;
    }


    /**
     * Set the value of ScZuoye
     *
     * @param v new value
     */
    public void setScZuoye(double v) 
    {

        if (this.scZuoye != v)
        {
            this.scZuoye = v;
            setModified(true);
        }


    }

    /**
     * Get the ScChuqin
     *
     * @return double
     */
    public double getScChuqin()
    {
        return scChuqin;
    }


    /**
     * Set the value of ScChuqin
     *
     * @param v new value
     */
    public void setScChuqin(double v) 
    {

        if (this.scChuqin != v)
        {
            this.scChuqin = v;
            setModified(true);
        }


    }

    /**
     * Get the ScAll
     *
     * @return double
     */
    public double getScAll()
    {
        return scAll;
    }


    /**
     * Set the value of ScAll
     *
     * @param v new value
     */
    public void setScAll(double v) 
    {

        if (this.scAll != v)
        {
            this.scAll = v;
            setModified(true);
        }


    }

    /**
     * Get the Sc40
     *
     * @return double
     */
    public double getSc40()
    {
        return sc40;
    }


    /**
     * Set the value of Sc40
     *
     * @param v new value
     */
    public void setSc40(double v) 
    {

        if (this.sc40 != v)
        {
            this.sc40 = v;
            setModified(true);
        }


    }

    /**
     * Get the Sc20
     *
     * @return double
     */
    public double getSc20()
    {
        return sc20;
    }


    /**
     * Set the value of Sc20
     *
     * @param v new value
     */
    public void setSc20(double v) 
    {

        if (this.sc20 != v)
        {
            this.sc20 = v;
            setModified(true);
        }


    }

    /**
     * Get the Remark
     *
     * @return String
     */
    public String getRemark()
    {
        return remark;
    }


    /**
     * Set the value of Remark
     *
     * @param v new value
     */
    public void setRemark(String v) 
    {

        if (!ObjectUtils.equals(this.remark, v))
        {
            this.remark = v;
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
            fieldNames.add("ClassId");
            fieldNames.add("KechengId");
            fieldNames.add("StudentId");
            fieldNames.add("ScKeguan");
            fieldNames.add("ScZhuguan");
            fieldNames.add("ScJuanmian");
            fieldNames.add("ScQizhong");
            fieldNames.add("ScZuoye");
            fieldNames.add("ScChuqin");
            fieldNames.add("ScAll");
            fieldNames.add("Sc40");
            fieldNames.add("Sc20");
            fieldNames.add("Remark");
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
        if (name.equals("ClassId"))
        {
            return new Integer(getClassId());
        }
        if (name.equals("KechengId"))
        {
            return new Integer(getKechengId());
        }
        if (name.equals("StudentId"))
        {
            return new Integer(getStudentId());
        }
        if (name.equals("ScKeguan"))
        {
            return new Double(getScKeguan());
        }
        if (name.equals("ScZhuguan"))
        {
            return new Double(getScZhuguan());
        }
        if (name.equals("ScJuanmian"))
        {
            return new Double(getScJuanmian());
        }
        if (name.equals("ScQizhong"))
        {
            return new Double(getScQizhong());
        }
        if (name.equals("ScZuoye"))
        {
            return new Double(getScZuoye());
        }
        if (name.equals("ScChuqin"))
        {
            return new Double(getScChuqin());
        }
        if (name.equals("ScAll"))
        {
            return new Double(getScAll());
        }
        if (name.equals("Sc40"))
        {
            return new Double(getSc40());
        }
        if (name.equals("Sc20"))
        {
            return new Double(getSc20());
        }
        if (name.equals("Remark"))
        {
            return getRemark();
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
        if (name.equals("ClassId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setClassId(((Integer) value).intValue());
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
        if (name.equals("StudentId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setStudentId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("ScKeguan"))
        {
            if (value == null || ! (Double.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Double object.");
            }
            setScKeguan(((Double) value).doubleValue());
            return true;
        }
        if (name.equals("ScZhuguan"))
        {
            if (value == null || ! (Double.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Double object.");
            }
            setScZhuguan(((Double) value).doubleValue());
            return true;
        }
        if (name.equals("ScJuanmian"))
        {
            if (value == null || ! (Double.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Double object.");
            }
            setScJuanmian(((Double) value).doubleValue());
            return true;
        }
        if (name.equals("ScQizhong"))
        {
            if (value == null || ! (Double.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Double object.");
            }
            setScQizhong(((Double) value).doubleValue());
            return true;
        }
        if (name.equals("ScZuoye"))
        {
            if (value == null || ! (Double.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Double object.");
            }
            setScZuoye(((Double) value).doubleValue());
            return true;
        }
        if (name.equals("ScChuqin"))
        {
            if (value == null || ! (Double.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Double object.");
            }
            setScChuqin(((Double) value).doubleValue());
            return true;
        }
        if (name.equals("ScAll"))
        {
            if (value == null || ! (Double.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Double object.");
            }
            setScAll(((Double) value).doubleValue());
            return true;
        }
        if (name.equals("Sc40"))
        {
            if (value == null || ! (Double.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Double object.");
            }
            setSc40(((Double) value).doubleValue());
            return true;
        }
        if (name.equals("Sc20"))
        {
            if (value == null || ! (Double.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Double object.");
            }
            setSc20(((Double) value).doubleValue());
            return true;
        }
        if (name.equals("Remark"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setRemark((String) value);
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
        if (name.equals(ScorePeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(ScorePeer.CLASS_ID))
        {
            return new Integer(getClassId());
        }
        if (name.equals(ScorePeer.KECHENG_ID))
        {
            return new Integer(getKechengId());
        }
        if (name.equals(ScorePeer.STUDENT_ID))
        {
            return new Integer(getStudentId());
        }
        if (name.equals(ScorePeer.SC_KEGUAN))
        {
            return new Double(getScKeguan());
        }
        if (name.equals(ScorePeer.SC_ZHUGUAN))
        {
            return new Double(getScZhuguan());
        }
        if (name.equals(ScorePeer.SC_JUANMIAN))
        {
            return new Double(getScJuanmian());
        }
        if (name.equals(ScorePeer.SC_QIZHONG))
        {
            return new Double(getScQizhong());
        }
        if (name.equals(ScorePeer.SC_ZUOYE))
        {
            return new Double(getScZuoye());
        }
        if (name.equals(ScorePeer.SC_CHUQIN))
        {
            return new Double(getScChuqin());
        }
        if (name.equals(ScorePeer.SC_ALL))
        {
            return new Double(getScAll());
        }
        if (name.equals(ScorePeer.SC_40))
        {
            return new Double(getSc40());
        }
        if (name.equals(ScorePeer.SC_20))
        {
            return new Double(getSc20());
        }
        if (name.equals(ScorePeer.REMARK))
        {
            return getRemark();
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
      if (ScorePeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (ScorePeer.CLASS_ID.equals(name))
        {
            return setByName("ClassId", value);
        }
      if (ScorePeer.KECHENG_ID.equals(name))
        {
            return setByName("KechengId", value);
        }
      if (ScorePeer.STUDENT_ID.equals(name))
        {
            return setByName("StudentId", value);
        }
      if (ScorePeer.SC_KEGUAN.equals(name))
        {
            return setByName("ScKeguan", value);
        }
      if (ScorePeer.SC_ZHUGUAN.equals(name))
        {
            return setByName("ScZhuguan", value);
        }
      if (ScorePeer.SC_JUANMIAN.equals(name))
        {
            return setByName("ScJuanmian", value);
        }
      if (ScorePeer.SC_QIZHONG.equals(name))
        {
            return setByName("ScQizhong", value);
        }
      if (ScorePeer.SC_ZUOYE.equals(name))
        {
            return setByName("ScZuoye", value);
        }
      if (ScorePeer.SC_CHUQIN.equals(name))
        {
            return setByName("ScChuqin", value);
        }
      if (ScorePeer.SC_ALL.equals(name))
        {
            return setByName("ScAll", value);
        }
      if (ScorePeer.SC_40.equals(name))
        {
            return setByName("Sc40", value);
        }
      if (ScorePeer.SC_20.equals(name))
        {
            return setByName("Sc20", value);
        }
      if (ScorePeer.REMARK.equals(name))
        {
            return setByName("Remark", value);
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
            return new Integer(getClassId());
        }
        if (pos == 2)
        {
            return new Integer(getKechengId());
        }
        if (pos == 3)
        {
            return new Integer(getStudentId());
        }
        if (pos == 4)
        {
            return new Double(getScKeguan());
        }
        if (pos == 5)
        {
            return new Double(getScZhuguan());
        }
        if (pos == 6)
        {
            return new Double(getScJuanmian());
        }
        if (pos == 7)
        {
            return new Double(getScQizhong());
        }
        if (pos == 8)
        {
            return new Double(getScZuoye());
        }
        if (pos == 9)
        {
            return new Double(getScChuqin());
        }
        if (pos == 10)
        {
            return new Double(getScAll());
        }
        if (pos == 11)
        {
            return new Double(getSc40());
        }
        if (pos == 12)
        {
            return new Double(getSc20());
        }
        if (pos == 13)
        {
            return getRemark();
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
            return setByName("ClassId", value);
        }
    if (position == 2)
        {
            return setByName("KechengId", value);
        }
    if (position == 3)
        {
            return setByName("StudentId", value);
        }
    if (position == 4)
        {
            return setByName("ScKeguan", value);
        }
    if (position == 5)
        {
            return setByName("ScZhuguan", value);
        }
    if (position == 6)
        {
            return setByName("ScJuanmian", value);
        }
    if (position == 7)
        {
            return setByName("ScQizhong", value);
        }
    if (position == 8)
        {
            return setByName("ScZuoye", value);
        }
    if (position == 9)
        {
            return setByName("ScChuqin", value);
        }
    if (position == 10)
        {
            return setByName("ScAll", value);
        }
    if (position == 11)
        {
            return setByName("Sc40", value);
        }
    if (position == 12)
        {
            return setByName("Sc20", value);
        }
    if (position == 13)
        {
            return setByName("Remark", value);
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
        save(ScorePeer.DATABASE_NAME);
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
                    ScorePeer.doInsert((Score) this, con);
                    setNew(false);
                }
                else
                {
                    ScorePeer.doUpdate((Score) this, con);
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
    public Score copy() throws TorqueException
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
    public Score copy(Connection con) throws TorqueException
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
    public Score copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new Score(), deepcopy);
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
    public Score copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new Score(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected Score copyInto(Score copyObj) throws TorqueException
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
    protected Score copyInto(Score copyObj, Connection con) throws TorqueException
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
    protected Score copyInto(Score copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setClassId(classId);
        copyObj.setKechengId(kechengId);
        copyObj.setStudentId(studentId);
        copyObj.setScKeguan(scKeguan);
        copyObj.setScZhuguan(scZhuguan);
        copyObj.setScJuanmian(scJuanmian);
        copyObj.setScQizhong(scQizhong);
        copyObj.setScZuoye(scZuoye);
        copyObj.setScChuqin(scChuqin);
        copyObj.setScAll(scAll);
        copyObj.setSc40(sc40);
        copyObj.setSc20(sc20);
        copyObj.setRemark(remark);

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
    protected Score copyInto(Score copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setClassId(classId);
        copyObj.setKechengId(kechengId);
        copyObj.setStudentId(studentId);
        copyObj.setScKeguan(scKeguan);
        copyObj.setScZhuguan(scZhuguan);
        copyObj.setScJuanmian(scJuanmian);
        copyObj.setScQizhong(scQizhong);
        copyObj.setScZuoye(scZuoye);
        copyObj.setScChuqin(scChuqin);
        copyObj.setScAll(scAll);
        copyObj.setSc40(sc40);
        copyObj.setSc20(sc20);
        copyObj.setRemark(remark);

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
    public ScorePeer getPeer()
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
        return ScorePeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("Score:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("ClassId = ")
           .append(getClassId())
           .append("\n");
        str.append("KechengId = ")
           .append(getKechengId())
           .append("\n");
        str.append("StudentId = ")
           .append(getStudentId())
           .append("\n");
        str.append("ScKeguan = ")
           .append(getScKeguan())
           .append("\n");
        str.append("ScZhuguan = ")
           .append(getScZhuguan())
           .append("\n");
        str.append("ScJuanmian = ")
           .append(getScJuanmian())
           .append("\n");
        str.append("ScQizhong = ")
           .append(getScQizhong())
           .append("\n");
        str.append("ScZuoye = ")
           .append(getScZuoye())
           .append("\n");
        str.append("ScChuqin = ")
           .append(getScChuqin())
           .append("\n");
        str.append("ScAll = ")
           .append(getScAll())
           .append("\n");
        str.append("Sc40 = ")
           .append(getSc40())
           .append("\n");
        str.append("Sc20 = ")
           .append(getSc20())
           .append("\n");
        str.append("Remark = ")
           .append(getRemark())
           .append("\n");
        return(str.toString());
    }
}
