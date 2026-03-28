import { useState, useEffect } from 'react';
import { Users, ShoppingCart, Package, DollarSign } from 'lucide-react';
import api from '../api/axios';
import './Dashboard.css';

export default function Dashboard() {
  const [stats, setStats] = useState({
    vendors: 0,
    pos: 0,
    items: 0,
    pendingApprovals: 0
  });

  const [recentVendors, setRecentVendors] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchDashboardData = async () => {
      try {
        setLoading(true);
        // We simulate a compound dashboard load or fetch from actual endpoints
        const [vendorsRes, poRes, itemsRes, approvalsRes] = await Promise.all([
          api.get('/vendors').catch(() => ({ data: [] })),
          api.get('/po').catch(() => ({ data: [] })),
          api.get('/items').catch(() => ({ data: [] })),
          api.get('/approvals').catch(() => ({ data: [] }))
        ]);

        setStats({
          vendors: vendorsRes.data?.length || 0,
          pos: poRes.data?.length || 0,
          items: itemsRes.data?.length || 0,
          pendingApprovals: approvalsRes.data?.filter(a => a.status === 'PENDING')?.length || 0
        });

        // Get top 5 recent vendors
        setRecentVendors((vendorsRes.data || []).slice(0, 5));
      } catch (error) {
        console.error("Dashboard data fetching error:", error);
      } finally {
        setLoading(false);
      }
    };

    fetchDashboardData();
  }, []);

  return (
    <div className="dashboard">
      <div className="dashboard-header">
        <div>
          <h1 className="title-gradient" style={{ fontSize: '2rem', marginBottom: '0.5rem' }}>Overview</h1>
          <p style={{ color: 'var(--text-secondary)' }}>Welcome back to ProcureFlow. Here's what's happening today.</p>
        </div>
        <button className="btn btn-primary" onClick={() => window.location.href='/procurement/new'}>
          Create Purchase Order
        </button>
      </div>

      <div className="grid-cards">
        <StatCard 
          title="Total Vendors" 
          value={loading ? '...' : stats.vendors} 
          icon={<Users size={24} />} 
          trend="+12% this month"
          color="var(--primary)"
        />
        <StatCard 
          title="Active POs" 
          value={loading ? '...' : stats.pos} 
          icon={<ShoppingCart size={24} />} 
          trend="+5% this month"
          color="var(--secondary)"
        />
        <StatCard 
          title="Inventory Items" 
          value={loading ? '...' : stats.items} 
          icon={<Package size={24} />} 
          trend="Stock at 85%"
          color="var(--warning)"
        />
        <StatCard 
          title="Pending Approvals" 
          value={loading ? '...' : stats.pendingApprovals} 
          icon={<DollarSign size={24} />} 
          trend="Needs attention"
          color="var(--danger)"
        />
      </div>

      <div className="dashboard-sections">
        <div className="glass-panel recent-vendors">
          <div className="section-header">
            <h3>Recent Vendors</h3>
            <a href="/vendors" className="text-link">View All</a>
          </div>
          {loading ? (
            <div className="loading-state">Loading data...</div>
          ) : (
            <div className="table-container">
              <table className="table">
                <thead>
                  <tr>
                    <th>Vendor Name</th>
                    <th>Email</th>
                    <th>Status</th>
                  </tr>
                </thead>
                <tbody>
                  {recentVendors.length > 0 ? recentVendors.map(vendor => (
                    <tr key={vendor.vendorId}>
                      <td style={{ fontWeight: 500 }}>{vendor.vendorName}</td>
                      <td>{vendor.email}</td>
                      <td>
                        <span className="badge badge-success">Active</span>
                      </td>
                    </tr>
                  )) : (
                    <tr><td colSpan="3" style={{ textAlign: 'center', color: 'var(--text-secondary)' }}>No vendors found.</td></tr>
                  )}
                </tbody>
              </table>
            </div>
          )}
        </div>
      </div>
    </div>
  );
}

function StatCard({ title, value, icon, trend, color }) {
  return (
    <div className="glass-panel stat-card">
      <div className="stat-header">
        <h3 className="stat-title">{title}</h3>
        <div className="icon-wrapper" style={{ color: color, backgroundColor: `${color}1A` }}>
          {icon}
        </div>
      </div>
      <div className="stat-value">{value}</div>
      <div className="stat-trend">{trend}</div>
    </div>
  );
}
