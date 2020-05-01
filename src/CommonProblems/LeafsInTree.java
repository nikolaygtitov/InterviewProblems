package CommonProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * Here's an example balance sheet:
 *     Balance Sheet
 *         Assets                                    $300
 *             Current Assets                        $250
 *                 Cash                              $100  print
 *                 Accounts Receivable               $50   print
 *                 Inventory                         $100  print
 *             Long-Term Assets                      $50   print
 *         Liabilities & Equity                      $1550
 *             Liabilities                           $650
 *                 Current Liabilities               $550
 *                     Accounts Payable              $300  print
 *                     Income Taxes Payable          $200  print
 *                     Sales Taxes Payable           $50   print
 *                     Short-Term Debt               $0    print
 *                     Prepaid Revenue               $0    print
 *                 Long-Term Liabilities             $100
 *                     Long-Term Debt                $100  print
 *             Equity                                $900
 *                 Paid-In Capital                   $200  print
 *                 Retained Earnings                 $300  print
 *                 Earnings                          $400  print
 */

public class LeafsInTree {
    private Map<String, ArrayList<String>> map;
    private String balanceSheetData = "BalanceSheet,Assets,300\nBalanceSheet,LiabilitiesAndEquity,1550\n" +
            "Assets,CurrentAssets,250\nAssets,LongTermAssets,50\nCurrentAssets,Cash,100\n" +
            "CurrentAssets,AccountsReceivable,50\nCurrentAssets,Inventory,100\nLiabilitiesAndEquity,Liabilities,650\n" +
            "LiabilitiesAndEquity,Equity,900\nLiabilities,CurrentLiabilities,550\n" +
            "Liabilities,LongTermLiabilities,100\nCurrentLiabilities,AccountsPayable,300\n" +
            "CurrentLiabilities,IncomeTaxesPayable,200\nCurrentLiabilities,SalesTaxesPayable,50\n" +
            "CurrentLiabilities,ShortTermDebt,0\nCurrentLiabilities,PrepaidRevenue,0\n" +
            "LongTermLiabilities,LongTermDebt,100\nEquity,PaidInCapital,200\nEquity,RetainedEarnings,300\n" +
            "Equity,Earnings,400";

    public LeafsInTree() {
        map = new HashMap<>();
    }

    public void buildMap() {
        String[] input = balanceSheetData.split("\\r?\\n");
        String[] arguments;
        for (String line : input) {
            arguments = line.split(",");
            if (arguments.length == 3) {
                if (map.containsKey(arguments[0])) {
                    map.get(arguments[0]).add(arguments[1]);
                } else {
                    ArrayList<String> list = new ArrayList();
                    list.add(arguments[1]);
                    map.put(arguments[0], list);
                }
                map.put(arguments[1], new ArrayList<>());
            } else {
                System.out.println("Error while reading the line!\nLine does not have 3 arguments:\n" +
                        arguments.toString());
            }
        }
        printLeafs();
    }

    private void printLeafs() {
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            if (entry.getValue().isEmpty()) {
                System.out.println(entry.getKey());
            }
        }
    }
}
