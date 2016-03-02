package com.hao.schoa.po.map;

import org.apache.torque.TorqueException;

/**
 * This is a Torque Generated class that is used to load all database map 
 * information at once.  This is useful because Torque's default behaviour
 * is to do a "lazy" load of mapping information, e.g. loading it only
 * when it is needed.<p>
 *
 * @see org.apache.torque.map.DatabaseMap#initialize() DatabaseMap.initialize() 
 */
public class SchoaMapInit
{
    public static final void init()
        throws TorqueException
    {
        com.hao.schoa.po.ChengjidanPrintHistoryPeer.getMapBuilder();
        com.hao.schoa.po.ClassesPeer.getMapBuilder();
        com.hao.schoa.po.ClassesKechengPeer.getMapBuilder();
        com.hao.schoa.po.ClassesStudentPeer.getMapBuilder();
        com.hao.schoa.po.CountryPeer.getMapBuilder();
        com.hao.schoa.po.KaoqinPeer.getMapBuilder();
        com.hao.schoa.po.KechengPeer.getMapBuilder();
        com.hao.schoa.po.LibrarysPeer.getMapBuilder();
        com.hao.schoa.po.MemberPeer.getMapBuilder();
        com.hao.schoa.po.MenuPeer.getMapBuilder();
        com.hao.schoa.po.RolePeer.getMapBuilder();
        com.hao.schoa.po.SchoaLogsPeer.getMapBuilder();
        com.hao.schoa.po.ScorePeer.getMapBuilder();
        com.hao.schoa.po.StudentPeer.getMapBuilder();
        com.hao.schoa.po.StudentStateLogPeer.getMapBuilder();
        com.hao.schoa.po.SysPrivilegePeer.getMapBuilder();
        com.hao.schoa.po.SysRolePrivilegePeer.getMapBuilder();
        com.hao.schoa.po.TeacherPeer.getMapBuilder();
        com.hao.schoa.po.XueqiPeer.getMapBuilder();
    }
}
