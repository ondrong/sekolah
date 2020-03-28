package com.hendisantika.sekolah.controller;

import com.hendisantika.sekolah.repository.PengumumanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 28/03/20
 * Time: 10.53
 */
@Slf4j
@PreAuthorize("hasAuthority('ADMIN')")
@Controller
@RequestMapping("admin/pengumuman")
public class PengumumanController {
    @Autowired
    private PengumumanRepository pengumumanRepository;

    @GetMapping
    public String pengumuman(Model model, Pageable pageable) {
        log.info("Menampilkan data untuk Halaman List Pengumuman.");
        model.addAttribute("pengumumanList", pengumumanRepository.findAll(pageable));
        return "admin/pengumuman/pengumuman-list";
    }
}