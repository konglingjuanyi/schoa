package com.hao.schoa.po.map;

import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.map.ColumnMap;
import org.apache.torque.map.DatabaseMap;
import org.apache.torque.map.MapBuilder;
import org.apache.torque.map.TableMap;

/**
  */
public class SysRolePrivilegeMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "com.hao.schoa.po.map.SysRolePrivilegeMapBuilder";

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

        dbMap.addTable("sys_role_privilege");
        TableMap tMap = dbMap.getTable("sys_role_privilege");
        tMap.setJavaName("SysRolePrivilege");
        tMap.setOMClass( com.hao.schoa.po.SysRolePrivilege.class );
        tMap.setPeerClass( com.hao.schoa.po.SysRolePrivilegePeer.class );
        tMap.setPrimaryKeyMethod("none");

        ColumnMap cMap = null;


  // ------------- Column: role_id --------------------
        cMap = new ColumnMap( "role_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(true);
        cMap.setJavaName( "RoleId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("角色");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(1);
        tMap.addColumn(cMap);
  // ------------- Column: privilege_id --------------------
        cMap = new ColumnMap( "privilege_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(true);
        cMap.setJavaName( "PrivilegeId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("权限");
        cMap.setDefault("0");
        cMap.setInheritance("false");
        cMap.setPosition(2);
        tMap.addColumn(cMap);
        tMap.setUseInheritance(false);
    }
}
