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
 * extended all references should be to PaperAnalysis
 */
public abstract class BasePaperAnalysis extends BaseObject
{
    /** The Peer class */
    private static final PaperAnalysisPeer peer =
        new PaperAnalysisPeer();


    /** The value for the id field */
    private int id;

    /** The value for the xueqiId field */
    private int xueqiId = 0;

    /** The value for the classesId field */
    private int classesId = 0;

    /** The value for the kechengId field */
    private int kechengId = 0;

    /** The value for the mingtiTeacher field */
    private String mingtiTeacher;

    /** The value for the kaoshiType field */
    private String kaoshiType;

    /** The value for the zl01 field */
    private int zl01 = 0;

    /** The value for the zl02 field */
    private int zl02 = 0;

    /** The value for the zl03 field */
    private int zl03 = 0;

    /** The value for the zl04 field */
    private int zl04 = 0;

    /** The value for the zl05 field */
    private int zl05 = 0;

    /** The value for the fen90 field */
    private int fen90 = 0;

    /** The value for the fen90Bili field */
    private double fen90Bili = 0;

    /** The value for the fen8089 field */
    private int fen8089 = 0;

    /** The value for the fen8089Bili field */
    private double fen8089Bili = 0;

    /** The value for the fen7079 field */
    private int fen7079 = 0;

    /** The value for the fen7079Bili field */
    private double fen7079Bili = 0;

    /** The value for the fen6069 field */
    private int fen6069 = 0;

    /** The value for the fen6069Bili field */
    private double fen6069Bili = 0;

    /** The value for the fen59 field */
    private int fen59 = 0;

    /** The value for the fen59Bili field */
    private double fen59Bili = 0;

    /** The value for the total field */
    private int total = 0;

    /** The value for the totalBili field */
    private double totalBili = 0;

    /** The value for the fenxi1 field */
    private String fenxi1;

    /** The value for the fenxi2 field */
    private String fenxi2;

    /** The value for the member field */
    private String member;

    /** The value for the updateTime field */
    private Date updateTime;


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
     * Get the MingtiTeacher
     *
     * @return String
     */
    public String getMingtiTeacher()
    {
        return mingtiTeacher;
    }


    /**
     * Set the value of MingtiTeacher
     *
     * @param v new value
     */
    public void setMingtiTeacher(String v) 
    {

        if (!ObjectUtils.equals(this.mingtiTeacher, v))
        {
            this.mingtiTeacher = v;
            setModified(true);
        }


    }

    /**
     * Get the KaoshiType
     *
     * @return String
     */
    public String getKaoshiType()
    {
        return kaoshiType;
    }


    /**
     * Set the value of KaoshiType
     *
     * @param v new value
     */
    public void setKaoshiType(String v) 
    {

        if (!ObjectUtils.equals(this.kaoshiType, v))
        {
            this.kaoshiType = v;
            setModified(true);
        }


    }

    /**
     * Get the Zl01
     *
     * @return int
     */
    public int getZl01()
    {
        return zl01;
    }


    /**
     * Set the value of Zl01
     *
     * @param v new value
     */
    public void setZl01(int v) 
    {

        if (this.zl01 != v)
        {
            this.zl01 = v;
            setModified(true);
        }


    }

    /**
     * Get the Zl02
     *
     * @return int
     */
    public int getZl02()
    {
        return zl02;
    }


    /**
     * Set the value of Zl02
     *
     * @param v new value
     */
    public void setZl02(int v) 
    {

        if (this.zl02 != v)
        {
            this.zl02 = v;
            setModified(true);
        }


    }

    /**
     * Get the Zl03
     *
     * @return int
     */
    public int getZl03()
    {
        return zl03;
    }


    /**
     * Set the value of Zl03
     *
     * @param v new value
     */
    public void setZl03(int v) 
    {

        if (this.zl03 != v)
        {
            this.zl03 = v;
            setModified(true);
        }


    }

    /**
     * Get the Zl04
     *
     * @return int
     */
    public int getZl04()
    {
        return zl04;
    }


    /**
     * Set the value of Zl04
     *
     * @param v new value
     */
    public void setZl04(int v) 
    {

        if (this.zl04 != v)
        {
            this.zl04 = v;
            setModified(true);
        }


    }

    /**
     * Get the Zl05
     *
     * @return int
     */
    public int getZl05()
    {
        return zl05;
    }


    /**
     * Set the value of Zl05
     *
     * @param v new value
     */
    public void setZl05(int v) 
    {

        if (this.zl05 != v)
        {
            this.zl05 = v;
            setModified(true);
        }


    }

    /**
     * Get the Fen90
     *
     * @return int
     */
    public int getFen90()
    {
        return fen90;
    }


    /**
     * Set the value of Fen90
     *
     * @param v new value
     */
    public void setFen90(int v) 
    {

        if (this.fen90 != v)
        {
            this.fen90 = v;
            setModified(true);
        }


    }

    /**
     * Get the Fen90Bili
     *
     * @return double
     */
    public double getFen90Bili()
    {
        return fen90Bili;
    }


    /**
     * Set the value of Fen90Bili
     *
     * @param v new value
     */
    public void setFen90Bili(double v) 
    {

        if (this.fen90Bili != v)
        {
            this.fen90Bili = v;
            setModified(true);
        }


    }

    /**
     * Get the Fen8089
     *
     * @return int
     */
    public int getFen8089()
    {
        return fen8089;
    }


    /**
     * Set the value of Fen8089
     *
     * @param v new value
     */
    public void setFen8089(int v) 
    {

        if (this.fen8089 != v)
        {
            this.fen8089 = v;
            setModified(true);
        }


    }

    /**
     * Get the Fen8089Bili
     *
     * @return double
     */
    public double getFen8089Bili()
    {
        return fen8089Bili;
    }


    /**
     * Set the value of Fen8089Bili
     *
     * @param v new value
     */
    public void setFen8089Bili(double v) 
    {

        if (this.fen8089Bili != v)
        {
            this.fen8089Bili = v;
            setModified(true);
        }


    }

    /**
     * Get the Fen7079
     *
     * @return int
     */
    public int getFen7079()
    {
        return fen7079;
    }


    /**
     * Set the value of Fen7079
     *
     * @param v new value
     */
    public void setFen7079(int v) 
    {

        if (this.fen7079 != v)
        {
            this.fen7079 = v;
            setModified(true);
        }


    }

    /**
     * Get the Fen7079Bili
     *
     * @return double
     */
    public double getFen7079Bili()
    {
        return fen7079Bili;
    }


    /**
     * Set the value of Fen7079Bili
     *
     * @param v new value
     */
    public void setFen7079Bili(double v) 
    {

        if (this.fen7079Bili != v)
        {
            this.fen7079Bili = v;
            setModified(true);
        }


    }

    /**
     * Get the Fen6069
     *
     * @return int
     */
    public int getFen6069()
    {
        return fen6069;
    }


    /**
     * Set the value of Fen6069
     *
     * @param v new value
     */
    public void setFen6069(int v) 
    {

        if (this.fen6069 != v)
        {
            this.fen6069 = v;
            setModified(true);
        }


    }

    /**
     * Get the Fen6069Bili
     *
     * @return double
     */
    public double getFen6069Bili()
    {
        return fen6069Bili;
    }


    /**
     * Set the value of Fen6069Bili
     *
     * @param v new value
     */
    public void setFen6069Bili(double v) 
    {

        if (this.fen6069Bili != v)
        {
            this.fen6069Bili = v;
            setModified(true);
        }


    }

    /**
     * Get the Fen59
     *
     * @return int
     */
    public int getFen59()
    {
        return fen59;
    }


    /**
     * Set the value of Fen59
     *
     * @param v new value
     */
    public void setFen59(int v) 
    {

        if (this.fen59 != v)
        {
            this.fen59 = v;
            setModified(true);
        }


    }

    /**
     * Get the Fen59Bili
     *
     * @return double
     */
    public double getFen59Bili()
    {
        return fen59Bili;
    }


    /**
     * Set the value of Fen59Bili
     *
     * @param v new value
     */
    public void setFen59Bili(double v) 
    {

        if (this.fen59Bili != v)
        {
            this.fen59Bili = v;
            setModified(true);
        }


    }

    /**
     * Get the Total
     *
     * @return int
     */
    public int getTotal()
    {
        return total;
    }


    /**
     * Set the value of Total
     *
     * @param v new value
     */
    public void setTotal(int v) 
    {

        if (this.total != v)
        {
            this.total = v;
            setModified(true);
        }


    }

    /**
     * Get the TotalBili
     *
     * @return double
     */
    public double getTotalBili()
    {
        return totalBili;
    }


    /**
     * Set the value of TotalBili
     *
     * @param v new value
     */
    public void setTotalBili(double v) 
    {

        if (this.totalBili != v)
        {
            this.totalBili = v;
            setModified(true);
        }


    }

    /**
     * Get the Fenxi1
     *
     * @return String
     */
    public String getFenxi1()
    {
        return fenxi1;
    }


    /**
     * Set the value of Fenxi1
     *
     * @param v new value
     */
    public void setFenxi1(String v) 
    {

        if (!ObjectUtils.equals(this.fenxi1, v))
        {
            this.fenxi1 = v;
            setModified(true);
        }


    }

    /**
     * Get the Fenxi2
     *
     * @return String
     */
    public String getFenxi2()
    {
        return fenxi2;
    }


    /**
     * Set the value of Fenxi2
     *
     * @param v new value
     */
    public void setFenxi2(String v) 
    {

        if (!ObjectUtils.equals(this.fenxi2, v))
        {
            this.fenxi2 = v;
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
     * Get the UpdateTime
     *
     * @return Date
     */
    public Date getUpdateTime()
    {
        return updateTime;
    }


    /**
     * Set the value of UpdateTime
     *
     * @param v new value
     */
    public void setUpdateTime(Date v) 
    {

        if (!ObjectUtils.equals(this.updateTime, v))
        {
            this.updateTime = v;
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
            fieldNames.add("XueqiId");
            fieldNames.add("ClassesId");
            fieldNames.add("KechengId");
            fieldNames.add("MingtiTeacher");
            fieldNames.add("KaoshiType");
            fieldNames.add("Zl01");
            fieldNames.add("Zl02");
            fieldNames.add("Zl03");
            fieldNames.add("Zl04");
            fieldNames.add("Zl05");
            fieldNames.add("Fen90");
            fieldNames.add("Fen90Bili");
            fieldNames.add("Fen8089");
            fieldNames.add("Fen8089Bili");
            fieldNames.add("Fen7079");
            fieldNames.add("Fen7079Bili");
            fieldNames.add("Fen6069");
            fieldNames.add("Fen6069Bili");
            fieldNames.add("Fen59");
            fieldNames.add("Fen59Bili");
            fieldNames.add("Total");
            fieldNames.add("TotalBili");
            fieldNames.add("Fenxi1");
            fieldNames.add("Fenxi2");
            fieldNames.add("Member");
            fieldNames.add("UpdateTime");
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
        if (name.equals("XueqiId"))
        {
            return new Integer(getXueqiId());
        }
        if (name.equals("ClassesId"))
        {
            return new Integer(getClassesId());
        }
        if (name.equals("KechengId"))
        {
            return new Integer(getKechengId());
        }
        if (name.equals("MingtiTeacher"))
        {
            return getMingtiTeacher();
        }
        if (name.equals("KaoshiType"))
        {
            return getKaoshiType();
        }
        if (name.equals("Zl01"))
        {
            return new Integer(getZl01());
        }
        if (name.equals("Zl02"))
        {
            return new Integer(getZl02());
        }
        if (name.equals("Zl03"))
        {
            return new Integer(getZl03());
        }
        if (name.equals("Zl04"))
        {
            return new Integer(getZl04());
        }
        if (name.equals("Zl05"))
        {
            return new Integer(getZl05());
        }
        if (name.equals("Fen90"))
        {
            return new Integer(getFen90());
        }
        if (name.equals("Fen90Bili"))
        {
            return new Double(getFen90Bili());
        }
        if (name.equals("Fen8089"))
        {
            return new Integer(getFen8089());
        }
        if (name.equals("Fen8089Bili"))
        {
            return new Double(getFen8089Bili());
        }
        if (name.equals("Fen7079"))
        {
            return new Integer(getFen7079());
        }
        if (name.equals("Fen7079Bili"))
        {
            return new Double(getFen7079Bili());
        }
        if (name.equals("Fen6069"))
        {
            return new Integer(getFen6069());
        }
        if (name.equals("Fen6069Bili"))
        {
            return new Double(getFen6069Bili());
        }
        if (name.equals("Fen59"))
        {
            return new Integer(getFen59());
        }
        if (name.equals("Fen59Bili"))
        {
            return new Double(getFen59Bili());
        }
        if (name.equals("Total"))
        {
            return new Integer(getTotal());
        }
        if (name.equals("TotalBili"))
        {
            return new Double(getTotalBili());
        }
        if (name.equals("Fenxi1"))
        {
            return getFenxi1();
        }
        if (name.equals("Fenxi2"))
        {
            return getFenxi2();
        }
        if (name.equals("Member"))
        {
            return getMember();
        }
        if (name.equals("UpdateTime"))
        {
            return getUpdateTime();
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
        if (name.equals("XueqiId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setXueqiId(((Integer) value).intValue());
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
        if (name.equals("KechengId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setKechengId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("MingtiTeacher"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setMingtiTeacher((String) value);
            return true;
        }
        if (name.equals("KaoshiType"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setKaoshiType((String) value);
            return true;
        }
        if (name.equals("Zl01"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setZl01(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Zl02"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setZl02(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Zl03"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setZl03(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Zl04"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setZl04(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Zl05"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setZl05(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Fen90"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setFen90(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Fen90Bili"))
        {
            if (value == null || ! (Double.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Double object.");
            }
            setFen90Bili(((Double) value).doubleValue());
            return true;
        }
        if (name.equals("Fen8089"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setFen8089(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Fen8089Bili"))
        {
            if (value == null || ! (Double.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Double object.");
            }
            setFen8089Bili(((Double) value).doubleValue());
            return true;
        }
        if (name.equals("Fen7079"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setFen7079(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Fen7079Bili"))
        {
            if (value == null || ! (Double.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Double object.");
            }
            setFen7079Bili(((Double) value).doubleValue());
            return true;
        }
        if (name.equals("Fen6069"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setFen6069(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Fen6069Bili"))
        {
            if (value == null || ! (Double.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Double object.");
            }
            setFen6069Bili(((Double) value).doubleValue());
            return true;
        }
        if (name.equals("Fen59"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setFen59(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Fen59Bili"))
        {
            if (value == null || ! (Double.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Double object.");
            }
            setFen59Bili(((Double) value).doubleValue());
            return true;
        }
        if (name.equals("Total"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setTotal(((Integer) value).intValue());
            return true;
        }
        if (name.equals("TotalBili"))
        {
            if (value == null || ! (Double.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not a Double object.");
            }
            setTotalBili(((Double) value).doubleValue());
            return true;
        }
        if (name.equals("Fenxi1"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setFenxi1((String) value);
            return true;
        }
        if (name.equals("Fenxi2"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setFenxi2((String) value);
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
        if (name.equals("UpdateTime"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setUpdateTime((Date) value);
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
        if (name.equals(PaperAnalysisPeer.ID))
        {
            return new Integer(getId());
        }
        if (name.equals(PaperAnalysisPeer.XUEQI_ID))
        {
            return new Integer(getXueqiId());
        }
        if (name.equals(PaperAnalysisPeer.CLASSES_ID))
        {
            return new Integer(getClassesId());
        }
        if (name.equals(PaperAnalysisPeer.KECHENG_ID))
        {
            return new Integer(getKechengId());
        }
        if (name.equals(PaperAnalysisPeer.MINGTI_TEACHER))
        {
            return getMingtiTeacher();
        }
        if (name.equals(PaperAnalysisPeer.KAOSHI_TYPE))
        {
            return getKaoshiType();
        }
        if (name.equals(PaperAnalysisPeer.ZL_01))
        {
            return new Integer(getZl01());
        }
        if (name.equals(PaperAnalysisPeer.ZL_02))
        {
            return new Integer(getZl02());
        }
        if (name.equals(PaperAnalysisPeer.ZL_03))
        {
            return new Integer(getZl03());
        }
        if (name.equals(PaperAnalysisPeer.ZL_04))
        {
            return new Integer(getZl04());
        }
        if (name.equals(PaperAnalysisPeer.ZL_05))
        {
            return new Integer(getZl05());
        }
        if (name.equals(PaperAnalysisPeer.FEN_90))
        {
            return new Integer(getFen90());
        }
        if (name.equals(PaperAnalysisPeer.FEN_90_BILI))
        {
            return new Double(getFen90Bili());
        }
        if (name.equals(PaperAnalysisPeer.FEN_8089))
        {
            return new Integer(getFen8089());
        }
        if (name.equals(PaperAnalysisPeer.FEN_8089_BILI))
        {
            return new Double(getFen8089Bili());
        }
        if (name.equals(PaperAnalysisPeer.FEN_7079))
        {
            return new Integer(getFen7079());
        }
        if (name.equals(PaperAnalysisPeer.FEN_7079_BILI))
        {
            return new Double(getFen7079Bili());
        }
        if (name.equals(PaperAnalysisPeer.FEN_6069))
        {
            return new Integer(getFen6069());
        }
        if (name.equals(PaperAnalysisPeer.FEN_6069_BILI))
        {
            return new Double(getFen6069Bili());
        }
        if (name.equals(PaperAnalysisPeer.FEN_59))
        {
            return new Integer(getFen59());
        }
        if (name.equals(PaperAnalysisPeer.FEN_59_BILI))
        {
            return new Double(getFen59Bili());
        }
        if (name.equals(PaperAnalysisPeer.TOTAL))
        {
            return new Integer(getTotal());
        }
        if (name.equals(PaperAnalysisPeer.TOTAL_BILI))
        {
            return new Double(getTotalBili());
        }
        if (name.equals(PaperAnalysisPeer.FENXI_1))
        {
            return getFenxi1();
        }
        if (name.equals(PaperAnalysisPeer.FENXI_2))
        {
            return getFenxi2();
        }
        if (name.equals(PaperAnalysisPeer.MEMBER))
        {
            return getMember();
        }
        if (name.equals(PaperAnalysisPeer.UPDATE_TIME))
        {
            return getUpdateTime();
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
      if (PaperAnalysisPeer.ID.equals(name))
        {
            return setByName("Id", value);
        }
      if (PaperAnalysisPeer.XUEQI_ID.equals(name))
        {
            return setByName("XueqiId", value);
        }
      if (PaperAnalysisPeer.CLASSES_ID.equals(name))
        {
            return setByName("ClassesId", value);
        }
      if (PaperAnalysisPeer.KECHENG_ID.equals(name))
        {
            return setByName("KechengId", value);
        }
      if (PaperAnalysisPeer.MINGTI_TEACHER.equals(name))
        {
            return setByName("MingtiTeacher", value);
        }
      if (PaperAnalysisPeer.KAOSHI_TYPE.equals(name))
        {
            return setByName("KaoshiType", value);
        }
      if (PaperAnalysisPeer.ZL_01.equals(name))
        {
            return setByName("Zl01", value);
        }
      if (PaperAnalysisPeer.ZL_02.equals(name))
        {
            return setByName("Zl02", value);
        }
      if (PaperAnalysisPeer.ZL_03.equals(name))
        {
            return setByName("Zl03", value);
        }
      if (PaperAnalysisPeer.ZL_04.equals(name))
        {
            return setByName("Zl04", value);
        }
      if (PaperAnalysisPeer.ZL_05.equals(name))
        {
            return setByName("Zl05", value);
        }
      if (PaperAnalysisPeer.FEN_90.equals(name))
        {
            return setByName("Fen90", value);
        }
      if (PaperAnalysisPeer.FEN_90_BILI.equals(name))
        {
            return setByName("Fen90Bili", value);
        }
      if (PaperAnalysisPeer.FEN_8089.equals(name))
        {
            return setByName("Fen8089", value);
        }
      if (PaperAnalysisPeer.FEN_8089_BILI.equals(name))
        {
            return setByName("Fen8089Bili", value);
        }
      if (PaperAnalysisPeer.FEN_7079.equals(name))
        {
            return setByName("Fen7079", value);
        }
      if (PaperAnalysisPeer.FEN_7079_BILI.equals(name))
        {
            return setByName("Fen7079Bili", value);
        }
      if (PaperAnalysisPeer.FEN_6069.equals(name))
        {
            return setByName("Fen6069", value);
        }
      if (PaperAnalysisPeer.FEN_6069_BILI.equals(name))
        {
            return setByName("Fen6069Bili", value);
        }
      if (PaperAnalysisPeer.FEN_59.equals(name))
        {
            return setByName("Fen59", value);
        }
      if (PaperAnalysisPeer.FEN_59_BILI.equals(name))
        {
            return setByName("Fen59Bili", value);
        }
      if (PaperAnalysisPeer.TOTAL.equals(name))
        {
            return setByName("Total", value);
        }
      if (PaperAnalysisPeer.TOTAL_BILI.equals(name))
        {
            return setByName("TotalBili", value);
        }
      if (PaperAnalysisPeer.FENXI_1.equals(name))
        {
            return setByName("Fenxi1", value);
        }
      if (PaperAnalysisPeer.FENXI_2.equals(name))
        {
            return setByName("Fenxi2", value);
        }
      if (PaperAnalysisPeer.MEMBER.equals(name))
        {
            return setByName("Member", value);
        }
      if (PaperAnalysisPeer.UPDATE_TIME.equals(name))
        {
            return setByName("UpdateTime", value);
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
            return new Integer(getXueqiId());
        }
        if (pos == 2)
        {
            return new Integer(getClassesId());
        }
        if (pos == 3)
        {
            return new Integer(getKechengId());
        }
        if (pos == 4)
        {
            return getMingtiTeacher();
        }
        if (pos == 5)
        {
            return getKaoshiType();
        }
        if (pos == 6)
        {
            return new Integer(getZl01());
        }
        if (pos == 7)
        {
            return new Integer(getZl02());
        }
        if (pos == 8)
        {
            return new Integer(getZl03());
        }
        if (pos == 9)
        {
            return new Integer(getZl04());
        }
        if (pos == 10)
        {
            return new Integer(getZl05());
        }
        if (pos == 11)
        {
            return new Integer(getFen90());
        }
        if (pos == 12)
        {
            return new Double(getFen90Bili());
        }
        if (pos == 13)
        {
            return new Integer(getFen8089());
        }
        if (pos == 14)
        {
            return new Double(getFen8089Bili());
        }
        if (pos == 15)
        {
            return new Integer(getFen7079());
        }
        if (pos == 16)
        {
            return new Double(getFen7079Bili());
        }
        if (pos == 17)
        {
            return new Integer(getFen6069());
        }
        if (pos == 18)
        {
            return new Double(getFen6069Bili());
        }
        if (pos == 19)
        {
            return new Integer(getFen59());
        }
        if (pos == 20)
        {
            return new Double(getFen59Bili());
        }
        if (pos == 21)
        {
            return new Integer(getTotal());
        }
        if (pos == 22)
        {
            return new Double(getTotalBili());
        }
        if (pos == 23)
        {
            return getFenxi1();
        }
        if (pos == 24)
        {
            return getFenxi2();
        }
        if (pos == 25)
        {
            return getMember();
        }
        if (pos == 26)
        {
            return getUpdateTime();
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
            return setByName("XueqiId", value);
        }
    if (position == 2)
        {
            return setByName("ClassesId", value);
        }
    if (position == 3)
        {
            return setByName("KechengId", value);
        }
    if (position == 4)
        {
            return setByName("MingtiTeacher", value);
        }
    if (position == 5)
        {
            return setByName("KaoshiType", value);
        }
    if (position == 6)
        {
            return setByName("Zl01", value);
        }
    if (position == 7)
        {
            return setByName("Zl02", value);
        }
    if (position == 8)
        {
            return setByName("Zl03", value);
        }
    if (position == 9)
        {
            return setByName("Zl04", value);
        }
    if (position == 10)
        {
            return setByName("Zl05", value);
        }
    if (position == 11)
        {
            return setByName("Fen90", value);
        }
    if (position == 12)
        {
            return setByName("Fen90Bili", value);
        }
    if (position == 13)
        {
            return setByName("Fen8089", value);
        }
    if (position == 14)
        {
            return setByName("Fen8089Bili", value);
        }
    if (position == 15)
        {
            return setByName("Fen7079", value);
        }
    if (position == 16)
        {
            return setByName("Fen7079Bili", value);
        }
    if (position == 17)
        {
            return setByName("Fen6069", value);
        }
    if (position == 18)
        {
            return setByName("Fen6069Bili", value);
        }
    if (position == 19)
        {
            return setByName("Fen59", value);
        }
    if (position == 20)
        {
            return setByName("Fen59Bili", value);
        }
    if (position == 21)
        {
            return setByName("Total", value);
        }
    if (position == 22)
        {
            return setByName("TotalBili", value);
        }
    if (position == 23)
        {
            return setByName("Fenxi1", value);
        }
    if (position == 24)
        {
            return setByName("Fenxi2", value);
        }
    if (position == 25)
        {
            return setByName("Member", value);
        }
    if (position == 26)
        {
            return setByName("UpdateTime", value);
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
        save(PaperAnalysisPeer.DATABASE_NAME);
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
                    PaperAnalysisPeer.doInsert((PaperAnalysis) this, con);
                    setNew(false);
                }
                else
                {
                    PaperAnalysisPeer.doUpdate((PaperAnalysis) this, con);
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
    public PaperAnalysis copy() throws TorqueException
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
    public PaperAnalysis copy(Connection con) throws TorqueException
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
    public PaperAnalysis copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new PaperAnalysis(), deepcopy);
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
    public PaperAnalysis copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new PaperAnalysis(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected PaperAnalysis copyInto(PaperAnalysis copyObj) throws TorqueException
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
    protected PaperAnalysis copyInto(PaperAnalysis copyObj, Connection con) throws TorqueException
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
    protected PaperAnalysis copyInto(PaperAnalysis copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setXueqiId(xueqiId);
        copyObj.setClassesId(classesId);
        copyObj.setKechengId(kechengId);
        copyObj.setMingtiTeacher(mingtiTeacher);
        copyObj.setKaoshiType(kaoshiType);
        copyObj.setZl01(zl01);
        copyObj.setZl02(zl02);
        copyObj.setZl03(zl03);
        copyObj.setZl04(zl04);
        copyObj.setZl05(zl05);
        copyObj.setFen90(fen90);
        copyObj.setFen90Bili(fen90Bili);
        copyObj.setFen8089(fen8089);
        copyObj.setFen8089Bili(fen8089Bili);
        copyObj.setFen7079(fen7079);
        copyObj.setFen7079Bili(fen7079Bili);
        copyObj.setFen6069(fen6069);
        copyObj.setFen6069Bili(fen6069Bili);
        copyObj.setFen59(fen59);
        copyObj.setFen59Bili(fen59Bili);
        copyObj.setTotal(total);
        copyObj.setTotalBili(totalBili);
        copyObj.setFenxi1(fenxi1);
        copyObj.setFenxi2(fenxi2);
        copyObj.setMember(member);
        copyObj.setUpdateTime(updateTime);

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
    protected PaperAnalysis copyInto(PaperAnalysis copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setId(id);
        copyObj.setXueqiId(xueqiId);
        copyObj.setClassesId(classesId);
        copyObj.setKechengId(kechengId);
        copyObj.setMingtiTeacher(mingtiTeacher);
        copyObj.setKaoshiType(kaoshiType);
        copyObj.setZl01(zl01);
        copyObj.setZl02(zl02);
        copyObj.setZl03(zl03);
        copyObj.setZl04(zl04);
        copyObj.setZl05(zl05);
        copyObj.setFen90(fen90);
        copyObj.setFen90Bili(fen90Bili);
        copyObj.setFen8089(fen8089);
        copyObj.setFen8089Bili(fen8089Bili);
        copyObj.setFen7079(fen7079);
        copyObj.setFen7079Bili(fen7079Bili);
        copyObj.setFen6069(fen6069);
        copyObj.setFen6069Bili(fen6069Bili);
        copyObj.setFen59(fen59);
        copyObj.setFen59Bili(fen59Bili);
        copyObj.setTotal(total);
        copyObj.setTotalBili(totalBili);
        copyObj.setFenxi1(fenxi1);
        copyObj.setFenxi2(fenxi2);
        copyObj.setMember(member);
        copyObj.setUpdateTime(updateTime);

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
    public PaperAnalysisPeer getPeer()
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
        return PaperAnalysisPeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("PaperAnalysis:\n");
        str.append("Id = ")
           .append(getId())
           .append("\n");
        str.append("XueqiId = ")
           .append(getXueqiId())
           .append("\n");
        str.append("ClassesId = ")
           .append(getClassesId())
           .append("\n");
        str.append("KechengId = ")
           .append(getKechengId())
           .append("\n");
        str.append("MingtiTeacher = ")
           .append(getMingtiTeacher())
           .append("\n");
        str.append("KaoshiType = ")
           .append(getKaoshiType())
           .append("\n");
        str.append("Zl01 = ")
           .append(getZl01())
           .append("\n");
        str.append("Zl02 = ")
           .append(getZl02())
           .append("\n");
        str.append("Zl03 = ")
           .append(getZl03())
           .append("\n");
        str.append("Zl04 = ")
           .append(getZl04())
           .append("\n");
        str.append("Zl05 = ")
           .append(getZl05())
           .append("\n");
        str.append("Fen90 = ")
           .append(getFen90())
           .append("\n");
        str.append("Fen90Bili = ")
           .append(getFen90Bili())
           .append("\n");
        str.append("Fen8089 = ")
           .append(getFen8089())
           .append("\n");
        str.append("Fen8089Bili = ")
           .append(getFen8089Bili())
           .append("\n");
        str.append("Fen7079 = ")
           .append(getFen7079())
           .append("\n");
        str.append("Fen7079Bili = ")
           .append(getFen7079Bili())
           .append("\n");
        str.append("Fen6069 = ")
           .append(getFen6069())
           .append("\n");
        str.append("Fen6069Bili = ")
           .append(getFen6069Bili())
           .append("\n");
        str.append("Fen59 = ")
           .append(getFen59())
           .append("\n");
        str.append("Fen59Bili = ")
           .append(getFen59Bili())
           .append("\n");
        str.append("Total = ")
           .append(getTotal())
           .append("\n");
        str.append("TotalBili = ")
           .append(getTotalBili())
           .append("\n");
        str.append("Fenxi1 = ")
           .append(getFenxi1())
           .append("\n");
        str.append("Fenxi2 = ")
           .append(getFenxi2())
           .append("\n");
        str.append("Member = ")
           .append(getMember())
           .append("\n");
        str.append("UpdateTime = ")
           .append(getUpdateTime())
           .append("\n");
        return(str.toString());
    }
}
