package com.hao.schoa.po.map;

import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.adapter.DB;
import org.apache.torque.map.ColumnMap;
import org.apache.torque.map.DatabaseMap;
import org.apache.torque.map.MapBuilder;
import org.apache.torque.map.TableMap;

/**
  */
public class RoleMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "com.hao.schoa.po.map.RoleMapBuilder";

    /**
     * The database map.
     */
    private DatabaseMap dbMap = null;

    /**
     * Tells us if this DatabaseMapBuilder is built so that we
     * don't have to re-build it every time.
     *
     * @return true if this DatabaseMapBuilder is built
     */
    public boolean isBuilt()
    {
        return (dbMap != null);
    }

    /**
     * Gets the databasemap this map builder built.
     *
     * @return the databasemap
     */
    public DatabaseMap getDatabaseMap()
    {
        return this.dbMap;
    }

    /**
     * The doBuild() method builds the DatabaseMap
     *
     * @throws TorqueException
     */
    public synchronized void doBuild() throws TorqueException
    {
        if ( isBuilt() ) {
            return;
        }
        dbMap = Torque.getDatabaseMap("schoa");

        dbMap.addTable("role");
        TableMap tMap = dbMap.getTable("role");
        tMap.setJavaName("Role");
        tMap.setOMClass( com.hao.schoa.po.Role.class );
        tMap.setPeerClass( com.hao.schoa.po.RolePeer.class );
        tMap.setPrimaryKeyMethod(TableMap.NATIVE);
        DB dbAdapter = Torque.getDB("schoa");
        if (dbAdapter.getIDMethodType().equals(DB.SEQUENCE))
        {
            tMap.setPrimaryKeyMethodInfo("role_SEQ");
        }
        else if (dbAdapter.getIDMethodType().equals(DB.AUTO_INCREMENT))
        {
            tMap.setPrimaryKeyMethodInfo("role");
        }

        ColumnMap cMap = null;


  // ------------- Column: id --------------------
        cMap = new ColumnMap( "id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(true);
        cMap.setNotNull(true);
        cMap.setJavaName( "Id" );
        cMap.setAutoIncrement(true);
        cMap.setProtected(false);
        cMap.setDescription("");
        cMap.setInheritance("false");
        cMap.setPosition(1);
        tMap.addColumn(cMap);
  // ------------- Column: name --------------------
        cMap = new ColumnMap( "name", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Name" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("角色名");
        cMap.setInheritance("false");
        cMap.setSize( 200 );
        cMap.setPosition(2);
        tMap.addColumn(cMap);
  // ------------- Column: intro --------------------
        cMap = new ColumnMap( "intro", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(false);
        cMap.setJavaName( "Intro" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("角色描述");
        cMap.setInheritance("false");
        cMap.setSize( 300 );
        cMap.setPosition(3);
        tMap.addColumn(cMap);
        tMap.setUseInheritance(false);
    }
}
