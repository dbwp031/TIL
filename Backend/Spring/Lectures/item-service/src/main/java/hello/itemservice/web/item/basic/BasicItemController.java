package hello.itemservice.web.item.basic;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.List;

// @RequiredArgsConstructor
// 1. final이 붙은 멤버변수만 사용해서 생성자를 자동으로 만들어준다.
// 2. -> 이 뜻은 public BasicItemController(ItemRepository itemRepository)가 자동 생성
// 3. -> final 1개 -> 생성자 1개 -> @Autowired 생략 가능
// 따라서 -> final 생략하면 DI 안됨.

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor // 어노테이션으로 초기화되지 않은 final 필드나 @NonNull이 붙은
// 필드에 대해 생성자를 생성해 준다.
public class BasicItemController {
    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }

//    @PostMapping("/add")
//    public String addItemV1(@RequestParam String itemName,
//                            @RequestParam int price,
//                            @RequestParam Integer quantity,
//                            Model model) {
//        Item item = new Item();
//        item.setItemName(itemName);
//        item.setPrice(price);
//        item.setQuantity(quantity);
//
//        itemRepository.save(item);
//        model.addAttribute("item", item);
//
//        return "basic/item";
//    }

    //    @PostMapping("/add")
//    public String addItemV2(@ModelAttribute("item") Item item, Model model) {
//        itemRepository.save(item);
//        // model.addAttribute("item", item); // 자동 추가, 생략 가능
//        return "basic/item";
//    }
//    @PostMapping("/add")
//    public String addItemV3(@ModelAttribute Item item) { //@ModelAttribute에서 이름 생략하면, class이름을 카멜 표기법으로 작성
//        itemRepository.save(item);
//        return "basic/item";
//    }
//
//    @PostMapping("/add")
//    public String addItemV4(Item item) { // @ModelAttribute 생략 가능
//        itemRepository.save(item);
//        return "basic/item";
//    }
//    @PostMapping("/add")
//    public String addItemV5(Item item) { // @ModelAttribute 생략 가능
//        itemRepository.save(item);
//        return "redirect:/basic/items/" + item.getId(); // redirect는 절대경로 사용
//    }
    @PostMapping("/add")
    public String addItemV6(Item item, RedirectAttributes redirectAttributes) { // @ModelAttribute 생략 가능
        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/basic/items/{itemId}";
    }
    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute Item item) {
        itemRepository.update(itemId, item);
        return "redirect:/basic/items/{itemId}"; // redirect는 상대경로 사용
    }
    /*
     * 테스트용 데이터 추가
     *  테스트용 데이터가 없으면 회원 목록 기능이 정상 동작하는지 확인 어렵다
     *  @PostConstruct -> 해당 빈의 의존관계가 모두 주입되고 나면 초기화 용도로 호출
     * */
    @PostConstruct // 의존관계 주입이 이루어진 후에 초기화를 수행하는 메서드에 붙이는 어노테이션
    public void init() {
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20000, 20));
    }



}
