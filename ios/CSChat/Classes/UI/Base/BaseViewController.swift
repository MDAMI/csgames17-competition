//
//  BaseViewController.swift
//  CSChat
//
//  Created by Émile Bélair on 17-03-23.
//  Copyright © 2017 Mirego. All rights reserved.
//

import SVProgressHUD

class BaseViewController: UIViewController
{
    var viewControllerFactory: ViewControllerFactory!

    fileprivate var loadingStartDate: Date?
    
    init()
    {
        super.init(nibName: nil, bundle: nil)
    }
    
    required init?(coder aDecoder: NSCoder)
    {
        fatalError("init(coder:) has not been implemented")
    }
    
}

// MARK: Loading Indicator
extension BaseViewController
{
    func showLoadingIndicator()
    {
        loadingStartDate = Date()
        SVProgressHUD.show()
    }
    
    func hideLoadingIndicator(success: Bool, message: String? = nil, completion: (() -> ())? = nil)
    {
        var duration: TimeInterval = 0
        
        if let startDate = loadingStartDate
        {
            let loadingDuration = -startDate.timeIntervalSinceNow
            duration = max(0, Stylesheet.minimumLoadingDuration - loadingDuration)
        }
        
        loadingStartDate = nil
        
        delay(duration) {
            if let message = message {
                if (success) {
                    SVProgressHUD.showSuccess(withStatus: message)
                } else {
                    SVProgressHUD.showError(withStatus: message)
                }
            } else {
                SVProgressHUD.dismiss()
            }
            
            completion?()
        }
    }
}