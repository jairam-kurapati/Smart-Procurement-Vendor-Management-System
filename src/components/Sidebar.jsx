import { Link, useLocation } from 'react-router-dom';
import { 
  LayoutDashboard, 
  Users, 
  ShoppingCart, 
  Package, 
  FileText, 
  CreditCard, 
  CheckSquare 
} from 'lucide-react';
import './Sidebar.css';

const navItems = [
  { path: '/', icon: LayoutDashboard, label: 'Dashboard' },
  { path: '/vendors', icon: Users, label: 'Vendors' },
  { path: '/procurement', icon: ShoppingCart, label: 'Procurement' },
  { path: '/inventory', icon: Package, label: 'Inventory' },
  { path: '/invoices', icon: FileText, label: 'Invoices' },
  { path: '/payments', icon: CreditCard, label: 'Payments' },
  { path: '/approvals', icon: CheckSquare, label: 'Approvals' },
];

export default function Sidebar() {
  const location = useLocation();

  return (
    <aside className="sidebar glass-panel">
      <div className="sidebar-header">
        <div className="logo-icon">SP</div>
        <h2 className="title-gradient">ProcureFlow</h2>
      </div>
      <nav className="sidebar-nav">
        {navItems.map((item) => {
          const Icon = item.icon;
          const isActive = location.pathname === item.path || 
                          (item.path !== '/' && location.pathname.startsWith(item.path));
          
          return (
            <Link 
              key={item.path} 
              to={item.path} 
              className={`nav-item ${isActive ? 'active' : ''}`}
            >
              <Icon size={20} className="nav-icon" />
              <span>{item.label}</span>
            </Link>
          );
        })}
      </nav>
    </aside>
  );
}
