package com.pjboy.backtemplate.service;

import com.pjboy.backtemplate.model.AdminVO;

import java.util.List;

public interface AdminService {
  AdminVO saveAdmin(AdminVO admin);

  void deleteAdmin(Long id);

  void updateAdmin(AdminVO admin);

  AdminVO getAdmin(Long id);

  List<AdminVO> getAll();
}
