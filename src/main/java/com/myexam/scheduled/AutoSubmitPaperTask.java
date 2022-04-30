package com.myexam.scheduled;

import com.myexam.service.PaperService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class AutoSubmitPaperTask {
    @Resource
    PaperService paperService;

    @Scheduled(fixedRate = 30000)
    public void scheduledTask() {
        paperService.autoSubmitPaper();
    }

}
