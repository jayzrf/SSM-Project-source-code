package cn.itcast.scm.action;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.scm.entity.Goods;
import cn.itcast.scm.entity.Page;
import cn.itcast.scm.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsAction extends BaseAction {
	@Resource
	private GoodsService goodsService;	
	
	//閫氳繃鍏抽敭瀛楀垎椤垫煡璇�
	@SuppressWarnings("rawtypes")
	@RequestMapping("/selectPageUseDyc")
	@ResponseBody //濡傛灉杩斿洖json鏍煎紡锛岄渶瑕佽繖涓敞瑙ｏ紝杩欓噷鐢ㄦ潵娴嬭瘯鐜
	public Object selectPageUseDyc(Page<Goods> page,Goods goods){
		
		page.setParamEntity(goods);
		System.out.println("----page:"+page);

		Page p = goodsService.selectPageUseDyc(page);
		//supplier.setSupName("supName1");
		/*Map<String, Object> map =new HashMap<String, Object>();
		map.put("total",p.getTotalRecord());
		map.put("rows",p.getList());*/
		return p.getPageMap();
	}
	
	
}
