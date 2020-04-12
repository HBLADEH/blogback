package com.pjboy.backtemplate.service;

import com.pjboy.backtemplate.dao.Admin;
import com.pjboy.backtemplate.dao.AdminRepository;
import com.pjboy.backtemplate.model.AdminVO;
import com.pjboy.backtemplate.utils.DozerUtils;
import org.dozer.Mapper;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

public class AdminJPAService implements AdminService {

  @Resource
  private AdminRepository adminRepository;

  @Resource
  private Mapper dozerMapper;

  @Override
  public AdminVO saveAdmin(AdminVO admin) {
    Admin adminPO = dozerMapper.map(admin,Admin.class);
    adminRepository.save(adminPO);
    return admin;
  }

  @Override
  public void deleteAdmin(Long id) {
    adminRepository.deleteById(id);
  }

  @Override
  public void updateAdmin(AdminVO admin) {
    Admin adminPO = dozerMapper.map(admin,Admin.class);
    adminRepository.save(adminPO);
  }

  @Override
  public AdminVO getAdmin(Long id) {
    Optional<Admin> admin = adminRepository.findById(id);
    return dozerMapper.map(admin.get(),AdminVO.class);
  }

  @Override
  public List<AdminVO> getAll() {
    List<Admin> adminList = adminRepository.findAll();
    return DozerUtils.mapList(adminList,AdminVO.class);
  }
}
