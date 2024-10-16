package org.example.dddlearning.interfaces;


import org.example.dddlearning.application.TransferApplicationService;
import org.example.dddlearning.domain.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @author: hanchaowei
 * @date 2024/10/11
 * @description:
 */

@RestController
@RequestMapping("/api")
public class TransferController {

	@Autowired
	private TransferApplicationService transferApplicationService;


	@PostMapping("/addUser")
	public String addUser(@RequestParam Long accountId, @RequestParam BigDecimal balance) {
		return  transferApplicationService.addUser(accountId, balance);
	}

	/**
	 * 转账
	 * @param fromAccountId
	 * @param toAccountId
	 * @param amount
	 * @return
	 */
	@PostMapping("/transfer")
	public String transfer(@RequestParam Long fromAccountId, @RequestParam Long toAccountId, @RequestParam BigDecimal amount) {
		transferApplicationService.transfer(fromAccountId, toAccountId, amount);
		return "转账成功......";
	}

	@GetMapping("/getUser")
	public AccountDTO getUser(@RequestParam Long accountId) {
		Account user = transferApplicationService.getUser(accountId);
		return new AccountDTO(user.getAccountId(), user.getBalance().getAmount());
	}

	
}
